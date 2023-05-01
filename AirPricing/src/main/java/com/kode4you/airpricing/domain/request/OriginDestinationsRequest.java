package com.kode4you.airpricing.domain.request;

import lombok.Data;

@Data
public class OriginDestinationsRequest {

    private String id;
    private String originLocationCode;
    private String destinationLocationCode;
    private DepartureDateTimeRangeRequest departureDateTimeRange;
}
