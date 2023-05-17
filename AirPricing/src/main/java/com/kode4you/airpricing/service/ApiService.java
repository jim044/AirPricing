package com.kode4you.airpricing.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kode4you.airpricing.domain.request.FlightOffersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class ApiService {

    @Value("${application.amadeus.base-path-v1}")
    private String basePathV1;

    @Value("${application.amadeus.base-path-v2}")
    private String basePathV2;

    @Value("${application.amadeus.endpoint-airport}")
    private String endpointAirport;

    @Value("${application.amadeus.endpoint-flight-offers}")
    private String endpointFlightOffers;

    public static final String AUTHORIZATION = "Authorization";
    private final TokenManager tokenManager;

    @Autowired
    @Qualifier("apiRestemplate")
    private RestTemplate restTemplate;

    public ApiService(
            TokenManager tokenManager,
            RestTemplate restTemplate) {
        this.tokenManager = tokenManager;
    }

    public String searchAirport(){
        String token = tokenManager.getAccessToken();

        String url = basePathV1 + endpointAirport;

        UriComponentsBuilder urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("subType", "AIRPORT")
                .queryParam("keyword", "MUC")
                .queryParam("page[limit]", "10")
                .queryParam("page[offset]", "0")
                .queryParam("sort", "analytics.travelers.score")
                .queryParam("view", "FULL").encode();

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, "Bearer " + token);
        headers.add("X-HTTP-Method-Override", "Get");
        HttpEntity<String> request = new HttpEntity<>(null, headers);

        ResponseEntity<String> response =
                restTemplate.exchange(urlTemplate.build().toUri(), HttpMethod.GET, request, String.class);

        return response.getBody();
    }

    public String searchFlight(FlightOffersRequest flightOffersRequest){
        String token = tokenManager.getAccessToken();

        String url = basePathV2 + endpointFlightOffers;

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObject = null;
        try {
            jsonObject = objectMapper.writeValueAsString(flightOffersRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, "Bearer " + token);
        headers.add("X-HTTP-Method-Override", "Get");
        headers.add("Content-Type", "application/json");
        HttpEntity<String> request = new HttpEntity<>(jsonObject, headers);

        String response =
                restTemplate.postForObject(url, request, String.class);

        return response;
    }

}
