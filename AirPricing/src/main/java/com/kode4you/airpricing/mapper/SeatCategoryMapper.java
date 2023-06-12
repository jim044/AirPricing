package com.kode4you.airpricing.mapper;

import com.kode4you.airpricing.domain.dto.SeatCategoryDto;
import com.kode4you.airpricing.domain.entity.SeatCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeatCategoryMapper {

    SeatCategoryDto seatCategoryEntityToSeatCategoryDto(SeatCategoryEntity entity);

    SeatCategoryEntity seatCategoryDtoToSeatCategoryEntity(SeatCategoryDto seatCategoryDto);

    List<SeatCategoryDto> seatCategoryEntitiesToSeatCategoryDtos(List<SeatCategoryEntity> itemList);

    List<SeatCategoryEntity> seatCategoryDtosToSeatCategoryEntities(List<SeatCategoryDto> itemDTOList);
}
