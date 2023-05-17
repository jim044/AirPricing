package com.kode4you.airpricing.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OriginDestinationsRequest {

    private String id;
    private String originLocationCode;
    private String destinationLocationCode;
    private DepartureDateTimeRangeRequest departureDateTimeRange;
}
