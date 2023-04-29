package com.kode4you.airpricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegrationManagement;


@SpringBootApplication
@ImportResource({"classpath:spring-integration/**/*.xml"})
@EnableIntegrationManagement
public class Application
{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
