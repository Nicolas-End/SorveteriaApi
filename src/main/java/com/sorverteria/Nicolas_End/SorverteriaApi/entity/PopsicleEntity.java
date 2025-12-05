package com.sorverteria.Nicolas_End.SorverteriaApi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name="TB_POPSICLE")
public class PopsicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String flavor;

    @Column(nullable = false)
    private int quantityInStock;

    @Column(nullable = false)
    private double priceByUnit;


}
