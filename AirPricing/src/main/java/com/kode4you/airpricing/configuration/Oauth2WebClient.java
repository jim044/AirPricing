package com.kode4you.airpricing.configuration;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import javax.net.ssl.SSLException;

@Configuration
public class Oauth2WebClient {

    private static final String AMADEUS_CLIENT_NAME = "amadeus";

    @Value("${application.configuration.webflux-buffer-size}")
    int webClientBufferSize;

    @Autowired
    private Environment env;

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientService authorizedClientService) {
        OAuth2AuthorizedClientProvider authorizedClientProvider =
                OAuth2AuthorizedClientProviderBuilder.builder()
                        .password()
                        .refreshToken()
                        .build();

        // Using AuthorizedClientServiceOAuth2AuthorizedClientManager instead of the DefaultOAuth2AuthorizedClientManager
        // to support asynchrone execution through the @Async annotation
        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
                new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, authorizedClientService);
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

        return authorizedClientManager;
    }

    @Bean
    public WebClient amadeusWebClient(OAuth2AuthorizedClientManager authorizedClientManager) throws SSLException {
        // May use a ServerAuth2AuthorizedClientExchangeFilterFunction in a reactive stack
        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
        HttpClient httpConnector = HttpClient.create().secure(t -> t.sslContext(sslContext) );

        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2Client =
                new ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
        oauth2Client.setDefaultClientRegistrationId(AMADEUS_CLIENT_NAME);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpConnector))
                .exchangeStrategies(ExchangeStrategies.builder().codecs(configurer -> configurer
                                .defaultCodecs()
                                .maxInMemorySize(webClientBufferSize))
                        .build())
                .baseUrl(env.getProperty("application.amadeus.base-path"))
                .apply(oauth2Client.oauth2Configuration())
                .build();
    }

}
