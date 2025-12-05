package com.sorverteria.Nicolas_End.SorverteriaApi.entity;

import jakarta.persistence.*;

import java.util.UUID;

// Essa entitade gerencia os pedidos de sorvetes feito pelos clientes
@Entity
@Table(name = "TB_USERS_ORDERS")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "popsicle_id")
    private PopsicleEntity popsicle;

    @Column(nullable = false)
    private int quantityOrdered;


}
