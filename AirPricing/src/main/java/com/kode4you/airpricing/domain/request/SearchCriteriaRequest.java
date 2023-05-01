package com.kode4you.airpricing.domain.request;

import lombok.Data;

@Data
public class SearchCriteriaRequest {

    private Integer maxFlightOffers;

    private FlightFiltersRequest flightFilters;
}
