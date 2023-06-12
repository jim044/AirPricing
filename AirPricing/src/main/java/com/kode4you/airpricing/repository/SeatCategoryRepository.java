package com.kode4you.airpricing.repository;

import com.kode4you.airpricing.domain.entity.SeatCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatCategoryRepository extends JpaRepository<SeatCategoryEntity, Long> {
}
