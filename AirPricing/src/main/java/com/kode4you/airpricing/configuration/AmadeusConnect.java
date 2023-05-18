package com.kode4you.airpricing.configuration;

import com.amadeus.Amadeus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AmadeusConnect {

    @Value("${spring.security.oauth2.client.registration.amadeus.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.amadeus.client-secret}")
    private String clientSecret;

    public Amadeus amadeusMethod() {
        return Amadeus
                .builder(clientId, clientSecret)
                .build();
    }
}
