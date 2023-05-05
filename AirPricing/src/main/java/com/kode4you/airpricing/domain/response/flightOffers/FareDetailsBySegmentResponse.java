package com.kode4you.airpricing.domain.response.flightOffers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FareDetailsBySegmentResponse {
    private String segmentId;
    private String cabin;
    private String fareBasis;
    @JsonProperty("class")
    private String classFareDetailsBySegmentResponse;
    private IncludedCheckedBagsResponse includedCheckedBags;
}
