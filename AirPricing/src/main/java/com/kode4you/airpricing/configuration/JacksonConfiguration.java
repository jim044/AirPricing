package com.kode4you.airpricing.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.integration.support.json.JsonObjectMapper;
import org.springframework.messaging.converter.MessageConverter;

@Configuration
public class JacksonConfiguration {

    @Bean
    @SuppressWarnings("rawtypes")
    JsonObjectMapper jsonObjectMapper(ObjectMapper objectMapper){
        return new Jackson2JsonObjectMapper(objectMapper);
    }
}
