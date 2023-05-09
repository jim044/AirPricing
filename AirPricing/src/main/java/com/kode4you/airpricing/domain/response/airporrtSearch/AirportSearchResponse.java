package com.kode4you.airpricing.domain.response.airporrtSearch;

import com.kode4you.airpricing.domain.response.commonResponse.MetaResponse;
import lombok.Data;

import java.util.List;

@Data
public class AirportSearchResponse {

    private MetaResponse meta;

    private List<DataAirportSearchResponse> data;
}
