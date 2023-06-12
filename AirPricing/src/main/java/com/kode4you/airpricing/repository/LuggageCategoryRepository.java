package com.kode4you.airpricing.repository;

import com.kode4you.airpricing.domain.entity.LuggageCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuggageCategoryRepository extends JpaRepository<LuggageCategoryEntity, Long> {
}
