package com.kode4you.airpricing.domain.response.flightOffers;

import lombok.Data;

@Data
public class SegmentsResponse {
    private DepartureResponse departure;
    private ArrivalResponse arrival;
    private String carrierCode;
    private String number;
    private AircraftResponse aircraft;
    private OperatingResponse operating;
    private String duration;
    private String id;
    private Integer numberOfStops;
    private Boolean blacklistedInEU;

}
