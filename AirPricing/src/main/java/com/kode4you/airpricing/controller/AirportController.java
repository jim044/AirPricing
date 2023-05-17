package com.kode4you.airpricing.controller;

import com.kode4you.airpricing.domain.response.airporrtSearch.AirportSearchResponse;
import com.kode4you.airpricing.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AirportController {

    @Autowired
    private ApiService apiService;

    @GetMapping(value = "/searchAirport/{airport}", produces = "application/json")
    public @ResponseBody String getBook(@PathVariable String airport) {
        return apiService.searchAirport();
    }
}
