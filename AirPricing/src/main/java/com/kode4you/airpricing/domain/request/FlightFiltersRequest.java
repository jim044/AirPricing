package com.kode4you.airpricing.domain.request;

import lombok.Data;

import java.util.List;

@Data
public class FlightFiltersRequest {

    private List<CabinRestrictionsRequest> cabinRestrictions;
}
