package com.kode4you.airpricing.configuration;

import com.google.gson.*;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class GsonConfiguration {

    static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Bean
    public GsonBuilder gsonBuilder(List<GsonBuilderCustomizer> customizers) {

        GsonBuilder builder = new GsonBuilder();
        // Enable the spring.gson.* configuration in the configuration file
        customizers.forEach(c -> c.customize(builder));

        /**
         * Custom Gson configuration
         */
        builder.registerTypeHierarchyAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {

            @Override
            public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(DATE_TIME_FORMATTER.format(src));
            }
        });

        return builder;
    }
}
