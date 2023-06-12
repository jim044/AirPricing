package com.kode4you.airpricing.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlertSearchFlightDto {

    private AirportDto airportDeparture;

    private AirportDto airportArrival;

    private LocalDateTime datetimeArrival;

    private LuggageCategoryDto luggageCategory;

    private PassengerCategoryDto passengerCategory;

    private SeatCategoryDto seatCategory;

    private FlightCategoryDto flightCategory;

    private Float maxPrice;

    private LocalDateTime searchStartDatetime;

    private LocalDateTime searchEndDatetime;

}
