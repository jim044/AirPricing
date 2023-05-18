package com.kode4you.airpricing.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportRequest {

    private String origin;
    private String destination;
    private String departDate;
    private String adults;
    private String returnDate;
}
