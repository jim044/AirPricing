package com.kode4you.airpricing.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteriaRequest {

    private Integer maxFlightOffers;

    private FlightFiltersRequest flightFilters;
}
