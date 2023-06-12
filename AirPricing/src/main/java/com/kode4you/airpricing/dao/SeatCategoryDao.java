
package com.kode4you.airpricing.dao;

import com.kode4you.airpricing.domain.dto.SeatCategoryDto;
import com.kode4you.airpricing.mapper.SeatCategoryMapper;
import com.kode4you.airpricing.repository.SeatCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatCategoryDao {

    @Autowired
    public SeatCategoryMapper seatCategoryMapper;
    @Autowired
    public SeatCategoryRepository seatCategoryRepository;

    public List<SeatCategoryDto> findAll(){
        return seatCategoryMapper.seatCategoryEntitiesToSeatCategoryDtos(seatCategoryRepository.findAll());
    }
}
