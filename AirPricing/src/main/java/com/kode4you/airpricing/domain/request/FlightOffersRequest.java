package com.kode4you.airpricing.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightOffersRequest {

    private String currencyCode;
    private List<OriginDestinationsRequest> originDestinations;
    private List<TravelersRequest> travelers;
    private List<String> sources;
    private SearchCriteriaRequest searchCriteria;
}
