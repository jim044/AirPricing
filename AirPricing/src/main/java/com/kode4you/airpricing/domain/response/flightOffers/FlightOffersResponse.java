package com.kode4you.airpricing.domain.response.flightOffers;

import lombok.Data;

import java.util.List;

@Data
public class FlightOffersResponse {

    private MetaResponse meta;

    private List<DataResponse> data;

    private DictionariesResponse dictionaries;


}
