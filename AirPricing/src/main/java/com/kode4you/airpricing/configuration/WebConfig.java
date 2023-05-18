package com.kode4you.airpricing.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfig {

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/**").permitAll()
                );

        return http.build();
    }

}
