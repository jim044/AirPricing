package com.kode4you.airpricing.domain.response.airporrtSearch;

import lombok.Data;

@Data
public class DataAirportSearchResponse {

    private String type;
    private String subType;
    private String name;
    private String detailedName;
    private String id;
    private SelfResponse self;
    private String timeZoneOffset;
    private String iataCode;
    private GeoCodeResponse geoCode;
    private AddressResponse address;
    private AnalyticsResponse analytics;

}
