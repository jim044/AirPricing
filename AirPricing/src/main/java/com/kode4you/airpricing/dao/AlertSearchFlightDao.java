
package com.kode4you.airpricing.dao;

import com.kode4you.airpricing.domain.dto.AlertSearchFlightDto;
import com.kode4you.airpricing.mapper.AlertSearchFlightMapper;
import com.kode4you.airpricing.repository.AlertSearchFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlertSearchFlightDao {

    @Autowired
    public AlertSearchFlightMapper alertSearchFlightMapper;
    @Autowired
    public AlertSearchFlightRepository alertSearchFlightRepository;

    public List<AlertSearchFlightDto> findAll(){
        return alertSearchFlightMapper.alertSearchFlightEntitiesToAlertSearchFlightDtos(alertSearchFlightRepository.findAll());
    }
}
