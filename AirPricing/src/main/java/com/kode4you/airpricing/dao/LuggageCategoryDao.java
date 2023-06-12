
package com.kode4you.airpricing.dao;

import com.kode4you.airpricing.domain.dto.LuggageCategoryDto;
import com.kode4you.airpricing.mapper.LuggageCategoryMapper;
import com.kode4you.airpricing.repository.LuggageCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LuggageCategoryDao {

    @Autowired
    public LuggageCategoryMapper luggageCategoryMapper;
    @Autowired
    public LuggageCategoryRepository luggageCategoryRepository;

    public List<LuggageCategoryDto> findAll(){
        return luggageCategoryMapper.luggageCategoryEntitiesToLuggageCategoryDtos(luggageCategoryRepository.findAll());
    }
}
