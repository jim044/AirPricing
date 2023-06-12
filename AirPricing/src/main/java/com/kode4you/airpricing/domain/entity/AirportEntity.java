package com.kode4you.airpricing.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "AIRPORT")
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @OneToMany(mappedBy="airportDeparture")
    private List<AlertSearchFlightEntity> alertSearchFlightDeparture;

    @OneToMany(mappedBy="airportArrival")
    private List<AlertSearchFlightEntity> alertSearchFlightArrival;

}
