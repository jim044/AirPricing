package com.kode4you.airpricing.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ResourceServerProxy {

    public static final String AUTHORIZATION = "Authorization";
    /*@Value("${resource.server.url}")
    private String resourceServerURL;*/
    private final TokenManager tokenManager;
    private final RestTemplate restTemplate;
    public ResourceServerProxy(
            TokenManager tokenManager,
            RestTemplate restTemplate) {
        this.tokenManager = tokenManager;
        this.restTemplate = restTemplate;
    }

}
