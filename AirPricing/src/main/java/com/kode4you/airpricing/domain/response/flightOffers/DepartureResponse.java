package com.kode4you.airpricing.domain.response.flightOffers;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DepartureResponse {

    private String iataCode;

    private LocalDateTime at;
}
