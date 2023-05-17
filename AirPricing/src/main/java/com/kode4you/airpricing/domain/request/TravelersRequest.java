package com.kode4you.airpricing.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelersRequest {

    private String id;
    private String travelerType;
}
