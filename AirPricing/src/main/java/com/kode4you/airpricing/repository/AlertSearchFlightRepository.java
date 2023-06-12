package com.kode4you.airpricing.repository;

import com.kode4you.airpricing.domain.entity.AlertSearchFlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertSearchFlightRepository extends JpaRepository<AlertSearchFlightEntity, Long> {
}
