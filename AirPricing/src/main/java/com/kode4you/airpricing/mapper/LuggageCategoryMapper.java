package com.kode4you.airpricing.mapper;

import com.kode4you.airpricing.domain.dto.LuggageCategoryDto;
import com.kode4you.airpricing.domain.entity.LuggageCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LuggageCategoryMapper {

    LuggageCategoryDto luggageCategoryEntityToLuggageCategoryDto(LuggageCategoryEntity entity);

    LuggageCategoryEntity luggageCategoryDtoToLuggageCategoryEntity(LuggageCategoryDto luggageCategoryDto);

    List<LuggageCategoryDto> luggageCategoryEntitiesToLuggageCategoryDtos(List<LuggageCategoryEntity> itemList);

    List<LuggageCategoryEntity> luggageCategoryDtosToLuggageCategoryEntities(List<LuggageCategoryDto> itemDTOList);
}
