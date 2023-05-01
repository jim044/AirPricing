package com.kode4you.airpricing.domain.request;

import lombok.Data;

import java.util.List;

@Data
public class FlightOffersRequest {

    private String currencyCode;
    private List<OriginDestinationsRequest> originDestinations;
    private List<TravelersRequest> travelers;
    private List<String> sources;
    private SearchCriteriaRequest searchCriteria;
}
