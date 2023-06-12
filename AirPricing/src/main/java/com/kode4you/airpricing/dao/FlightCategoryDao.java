
package com.kode4you.airpricing.dao;

import com.kode4you.airpricing.domain.dto.FlightCategoryDto;
import com.kode4you.airpricing.mapper.FlightCategoryMapper;
import com.kode4you.airpricing.repository.FlightCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightCategoryDao {

    @Autowired
    public FlightCategoryMapper flightCategoryMapper;
    @Autowired
    public FlightCategoryRepository flightCategoryRepository;

    public List<FlightCategoryDto> findAll(){
        return flightCategoryMapper.flightCategoryEntitiesToFlightCategoryDtos(flightCategoryRepository.findAll());
    }
}
