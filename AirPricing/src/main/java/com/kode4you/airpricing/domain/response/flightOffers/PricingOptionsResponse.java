package com.kode4you.airpricing.domain.response.flightOffers;

import lombok.Data;

import java.util.List;

@Data
public class PricingOptionsResponse {
    private List<String> fareType;
    private Boolean includedCheckedBagsOnly;

}
