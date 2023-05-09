package com.kode4you.airpricing.domain.response.flightOffers;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DataFlightOffersResponse {
    private String type;
    private String id;
    private String source;
    private Boolean instantTicketingRequired;
    private Boolean nonHomogeneous;
    private Boolean oneWay;
    private LocalDate lastTicketingDate;
    private LocalDate lastTicketingDateTime;
    private Integer numberOfBookableSeats;
    private List<ItinerariesResponse> itineraries;
    private PriceResponse price;
    private PricingOptionsResponse pricingOptions;
    private List<String> validatingAirlineCodes;
    private List<TravelerPricingsResponse> travelerPricings;
}
