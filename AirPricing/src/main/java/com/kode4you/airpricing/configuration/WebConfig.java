package com.kode4you.airpricing.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.oauth2Client();

        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/searchAirport/**").permitAll()
                );

        return http.build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
