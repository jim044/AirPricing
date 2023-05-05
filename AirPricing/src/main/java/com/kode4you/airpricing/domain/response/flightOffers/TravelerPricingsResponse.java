package com.kode4you.airpricing.domain.response.flightOffers;

import lombok.Data;

import java.util.List;

@Data
public class TravelerPricingsResponse {
    private String travelerId;
    private String fareOption;
    private String travelerType;
    private PriceResponse priceResponse;
    private List<FareDetailsBySegmentResponse> fareDetailsBySegment;
}
