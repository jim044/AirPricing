package com.kode4you.airpricing.mapper;

import com.kode4you.airpricing.domain.dto.PassengerCategoryDto;
import com.kode4you.airpricing.domain.entity.PassengerCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassengerCategoryMapper {

    PassengerCategoryDto passengerCategoryEntityToPassengerCategoryDto(PassengerCategoryEntity entity);

    PassengerCategoryEntity passengerCategoryDtoToPassengerCategoryEntity(PassengerCategoryDto passengerCategoryDto);

    List<PassengerCategoryDto> passengerCategoryEntitiesToPassengerCategoryDtos(List<PassengerCategoryEntity> itemList);

    List<PassengerCategoryEntity> passengerCategoryDtosToPassengerCategoryEntities(List<PassengerCategoryDto> itemDTOList);
}
