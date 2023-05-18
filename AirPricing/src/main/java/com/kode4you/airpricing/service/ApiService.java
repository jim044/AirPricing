package com.kode4you.airpricing.service;

import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;;
import com.amadeus.resources.Location;
import com.google.gson.Gson;
import com.kode4you.airpricing.configuration.AmadeusConnect;
import com.kode4you.airpricing.domain.request.AirportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiService {

    @Autowired
    private AmadeusConnect amadeusConnect;



    public Location[] searchAirport(String airportName) {
        Location[] locations = null;
        try {
            locations = amadeusConnect.amadeusMethod().referenceData.locations.get(
                    Params.with("subType", "AIRPORT")
                            .and("keyword", airportName));
        } catch (ResponseException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();

        return locations;
    }

    public FlightOfferSearch[] searchFlight(AirportRequest airportRequest){
        FlightOfferSearch[] flightOfferSearches = null;
        try {
            flightOfferSearches = amadeusConnect.amadeusMethod().shopping.flightOffersSearch.get(
                    Params.with("originLocationCode", airportRequest.getOrigin())
                            .and("destinationLocationCode", airportRequest.getDestination())
                            .and("departureDate", airportRequest.getDepartDate())
                            .and("returnDate", airportRequest.getReturnDate())
                            .and("adults", airportRequest.getAdults())
                            .and("max", 3));
        } catch (ResponseException e) {
            throw new RuntimeException(e);
        }

        return flightOfferSearches;
    }

}
