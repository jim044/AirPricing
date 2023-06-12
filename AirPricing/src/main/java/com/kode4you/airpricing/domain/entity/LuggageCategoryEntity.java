package com.kode4you.airpricing.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "LUGGAGE_CATEGORY")
public class LuggageCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy="luggageCategory")
    private List<AlertSearchFlightEntity> alertSearchFlight;
}
