package com.kode4you.airpricing.controller;

import com.kode4you.airpricing.domain.request.FlightOffersRequest;
import com.kode4you.airpricing.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FlightOffersController {

    @Autowired
    private ApiService apiService;

    @PostMapping(value = "/searchFlightOffers", produces = "application/json")
    public @ResponseBody String searchFlightOffers(@RequestBody FlightOffersRequest flightOffersRequest) {
        return apiService.searchFlight(flightOffersRequest);
    }
}
