package com.kode4you.airpricing.repository;

import com.kode4you.airpricing.domain.entity.FlightCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightCategoryRepository extends JpaRepository<FlightCategoryEntity, Long> {
}
