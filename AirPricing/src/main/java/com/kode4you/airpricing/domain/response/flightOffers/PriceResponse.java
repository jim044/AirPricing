package com.kode4you.airpricing.domain.response.flightOffers;

import lombok.Data;

import java.util.List;

@Data
public class PriceResponse {
    private String currency;
    private String total;
    private String base;
    private List<FeesResponse> fees;
    private String grandTotal;

}
