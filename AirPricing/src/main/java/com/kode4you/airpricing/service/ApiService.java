package com.kode4you.airpricing.service;

import com.kode4you.airpricing.domain.response.airporrtSearch.AirportSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Base64;

@Service
public class ApiService {

    @Autowired
    OAuth2RestTemplate oauth2RestTemplate;

    @Value("${application.amadeus.base-path-v1}")
    private String basePathV1;

    @Value("${application.amadeus.base-path-v2}")
    private String basePathV2;

    @Value("${application.amadeus.endpoint-airport}")
    private String endpointAirport;

    public AirportSearchResponse searchAirport(){
        String url = basePathV1 + endpointAirport + "?subType=AIRPORT&keyword=MUC&page%5Blimit%5D=10&page%5Boffset%5D=0&sort=analytics.travelers.score&view=FULL";
        AirportSearchResponse airportSearchResponse = oauth2RestTemplate.getForObject("https://test.api.amadeus.com/v1/reference-data/locations?subType=AIRPORT&keyword=MUC&page%5Blimit%5D=10&page%5Boffset%5D=0&sort=analytics.travelers.score&view=FULL", AirportSearchResponse.class);

        return airportSearchResponse;
    }
}
