package com.kode4you.airpricing.mapper;

import com.kode4you.airpricing.domain.dto.AlertSearchFlightDto;
import com.kode4you.airpricing.domain.entity.AlertSearchFlightEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AirportMapper.class, FlightCategoryMapper.class, LuggageCategoryMapper.class, PassengerCategoryMapper.class, SeatCategoryMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlertSearchFlightMapper {

    AlertSearchFlightDto alertSearchFlightEntityToAlertSearchFlightDto(AlertSearchFlightEntity entity);

    AlertSearchFlightEntity alertSearchFlightDtoToAlertSearchFlightEntity(AlertSearchFlightDto alertSearchFlightDto);

    List<AlertSearchFlightDto> alertSearchFlightEntitiesToAlertSearchFlightDtos(List<AlertSearchFlightEntity> itemList);

    List<AlertSearchFlightEntity> alertSearchFlightDtosToAlertSearchFlightEntities(List<AlertSearchFlightDto> itemDTOList);
}
