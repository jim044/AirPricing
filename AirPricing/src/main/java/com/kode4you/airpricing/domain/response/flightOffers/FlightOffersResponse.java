package com.kode4you.airpricing.domain.response.flightOffers;

import com.kode4you.airpricing.domain.response.commonResponse.MetaResponse;
import lombok.Data;

import java.util.List;

@Data
public class FlightOffersResponse {

    private MetaResponse meta;

    private List<DataFlightOffersResponse> data;

    private DictionariesResponse dictionaries;


}
