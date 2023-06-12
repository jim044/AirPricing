
package com.kode4you.airpricing.dao;

import com.kode4you.airpricing.domain.dto.PassengerCategoryDto;
import com.kode4you.airpricing.mapper.PassengerCategoryMapper;
import com.kode4you.airpricing.repository.PassengerCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassengerCategoryDao {

    @Autowired
    public PassengerCategoryMapper passengerCategoryMapper;
    @Autowired
    public PassengerCategoryRepository passengerCategoryRepository;

    public List<PassengerCategoryDto> findAll(){
        return passengerCategoryMapper.passengerCategoryEntitiesToPassengerCategoryDtos(passengerCategoryRepository.findAll());
    }
}
