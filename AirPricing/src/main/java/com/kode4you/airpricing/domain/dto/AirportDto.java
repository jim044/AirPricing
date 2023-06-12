package com.kode4you.airpricing.domain.dto;

import com.kode4you.airpricing.domain.entity.AlertSearchFlightEntity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class AirportDto {

    private String name;

    private String address;

    private String city;

    private String postalCode;

    private List<AlertSearchFlightDto> alertSearchFlightDeparture;

    private List<AlertSearchFlightDto> alertSearchFlightArrival;

}
