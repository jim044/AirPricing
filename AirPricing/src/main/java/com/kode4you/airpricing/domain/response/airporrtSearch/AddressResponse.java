package com.kode4you.airpricing.domain.response.airporrtSearch;

import lombok.Data;

@Data
public class AddressResponse {
    private String cityName;
    private String cityCode;
    private String countryName;
    private String countryCode;
    private String regionCode;
}
