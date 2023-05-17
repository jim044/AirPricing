package com.kode4you.airpricing.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Base64;

@Component
public class ApiService {

    @Value("${application.amadeus.base-path-v1}")
    private String basePathV1;

    @Value("${application.amadeus.base-path-v2}")
    private String basePathV2;

    @Value("${application.amadeus.endpoint-airport}")
    private String endpointAirport;

    public static final String AUTHORIZATION = "Authorization";
    private final TokenManager tokenManager;
    private final RestTemplate restTemplate;
    public ApiService(
            TokenManager tokenManager,
            RestTemplate restTemplate) {
        this.tokenManager = tokenManager;
        this.restTemplate = restTemplate;
    }

    public String searchAirport(){
        String token = tokenManager.getAccessToken();

        String url = basePathV1 + endpointAirport + "?subType=AIRPORT&keyword=MUC&page%5Blimit%5D=10&page%5Boffset%5D=0&sort=analytics.travelers.score&view=FULL";

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, "Bearer " + token);
        HttpEntity<String> request = new HttpEntity<>(null, headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        return response.getBody();
    }

}
