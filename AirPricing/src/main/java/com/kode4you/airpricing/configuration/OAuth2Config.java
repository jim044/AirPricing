package com.kode4you.airpricing.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@Configuration
public class OAuth2Config {

    @Value("${spring.security.oauth2.client.registration.amadeus.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.amadeus.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.provider.amadeus.token-uri}")
    private String tokenUrl;

    @Bean
    protected OAuth2ProtectedResourceDetails oauth2Resource() {
        ClientCredentialsResourceDetails clientCredentialsResourceDetails = new ClientCredentialsResourceDetails();
        clientCredentialsResourceDetails.setAccessTokenUri(tokenUrl);
        clientCredentialsResourceDetails.setClientId(clientId);
        clientCredentialsResourceDetails.setClientSecret(clientSecret);
        clientCredentialsResourceDetails.setGrantType("client_credentials"); //this depends on your specific OAuth2 server
        clientCredentialsResourceDetails.setAuthenticationScheme(AuthenticationScheme.header); //this again depends on the OAuth2 server specifications
        return clientCredentialsResourceDetails;
    }
    @Bean
    public OAuth2RestTemplate oauth2RestTemplate() {
        OAuth2RestTemplate oauth2RestTemplate = new OAuth2RestTemplate(oauth2Resource(), new DefaultOAuth2ClientContext());
        //oauth2RestTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        return oauth2RestTemplate;
    }
}
