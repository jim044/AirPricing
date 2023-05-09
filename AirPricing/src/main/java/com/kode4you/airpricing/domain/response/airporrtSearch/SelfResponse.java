package com.kode4you.airpricing.domain.response.airporrtSearch;

import lombok.Data;

import java.util.List;

@Data
public class SelfResponse {

    private String href;
    private List<String> methods;
}
