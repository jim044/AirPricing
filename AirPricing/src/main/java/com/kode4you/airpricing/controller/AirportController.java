package com.kode4you.airpricing.controller;

import com.amadeus.resources.Location;
import com.kode4you.airpricing.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AirportController {

    @Autowired
    private ApiService apiService;

    @GetMapping(value = "/searchAirport/{airportName}")
    public Location[] getAirport(@PathVariable String airportName) {
        return apiService.searchAirport(airportName);
    }
}
