package com.sorverteria.Nicolas_End.SorverteriaApi.domains.order;

import com.sorverteria.Nicolas_End.SorverteriaApi.enums.OrderStatus;
import jakarta.persistence.*;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.user.UserEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleEntity;
import lombok.Data;

import java.util.UUID;

// Essa entitade gerencia os pedidos de sorvetes feito pelos clientes
@Entity
@Table(name = "TB_USERS_ORDERS")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "popsicle_id")
    private PopsicleEntity popsicle;

    @Column(nullable = false)
    private int quantityOrdered;

    @Enumerated(EnumType.STRING)    
    @Column(nullable = false)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
