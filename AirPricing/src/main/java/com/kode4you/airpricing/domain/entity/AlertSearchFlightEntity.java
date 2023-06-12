package com.kode4you.airpricing.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ALERT_SEARCH_FLIGHT")
public class AlertSearchFlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_airport_departure")
    private AirportEntity airportDeparture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_airport_arrival")
    private AirportEntity airportArrival;

    @Column(name = "datetime_arrival")
    private LocalDateTime datetimeArrival;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_luggage_category")
    private LuggageCategoryEntity luggageCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_passenger_category")
    private PassengerCategoryEntity passengerCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seat_category")
    private SeatCategoryEntity seatCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_flight_category")
    private FlightCategoryEntity flightCategory;

    @Column(name = "max_price")
    private Float maxPrice;

    @Column(name = "search_start_datetime")
    private LocalDateTime searchStartDatetime;

    @Column(name = "search_end_datetime")
    private LocalDateTime searchEndDatetime;

}
