package com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.order.OrderEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
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

    // apaga todos os pedidos relacionados este sorvete
    @OneToMany(mappedBy = "popsicle", cascade = CascadeType.REMOVE)
    private List<OrderEntity> orders = new ArrayList<>();
}
