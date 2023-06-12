package com.kode4you.airpricing.mapper;

import com.kode4you.airpricing.domain.dto.FlightCategoryDto;
import com.kode4you.airpricing.domain.entity.FlightCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FlightCategoryMapper {

    FlightCategoryDto flightCategoryEntityToFlightCategoryDto(FlightCategoryEntity entity);

    FlightCategoryEntity flightCategoryDtoToFlightCategoryEntity(FlightCategoryDto flightCategoryDto);

    List<FlightCategoryDto> flightCategoryEntitiesToFlightCategoryDtos(List<FlightCategoryEntity> itemList);

    List<FlightCategoryEntity> flightCategoryDtosToFlightCategoryEntities(List<FlightCategoryDto> itemDTOList);
}
