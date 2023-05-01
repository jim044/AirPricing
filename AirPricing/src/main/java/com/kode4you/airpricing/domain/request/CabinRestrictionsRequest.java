package com.kode4you.airpricing.domain.request;

import lombok.Data;

import java.util.List;

@Data
public class CabinRestrictionsRequest {

    private String cabin;
    private String coverage;
    private List<String> originDestinationIds;
}
