package com.kode4you.airpricing.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "PASSENGER_CATEGORY")
public class PassengerCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy="passengerCategory")
    private List<AlertSearchFlightEntity> alertSearchFlight;
}
