package com.kode4you.airpricing.domain.response.flightOffers;

import lombok.Data;

import java.util.List;

@Data
public class ItinerariesResponse {
        private String duration;
        private List<SegmentsResponse> segments;
}
