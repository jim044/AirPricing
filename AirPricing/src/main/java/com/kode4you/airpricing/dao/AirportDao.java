
package com.kode4you.airpricing.dao;

import com.kode4you.airpricing.domain.dto.AirportDto;
import com.kode4you.airpricing.mapper.AirportMapper;
import com.kode4you.airpricing.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirportDao {

    @Autowired
    public AirportMapper airportMapper;
    @Autowired
    public AirportRepository airportRepository;

    public List<AirportDto> findAll(){
        return airportMapper.airportEntitiesToAirportDtos(airportRepository.findAll());
    }
}
