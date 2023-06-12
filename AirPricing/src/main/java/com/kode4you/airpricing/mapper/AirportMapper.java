package com.kode4you.airpricing.mapper;

import com.kode4you.airpricing.domain.dto.AirportDto;
import com.kode4you.airpricing.domain.entity.AirportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirportMapper {

    AirportDto airportEntityToAirportDto(AirportEntity entity);

    AirportEntity airportDtoToAirportEntity(AirportDto airportDto);

    List<AirportDto> airportEntitiesToAirportDtos(List<AirportEntity> itemList);

    List<AirportEntity> airportDtosToAirportEntities(List<AirportDto> itemDTOList);
}
