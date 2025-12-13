package com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits;

import jakarta.persistence.*;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai.AcaiToDeliveryEntity;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "TB_FRUITS")
@Entity
@Data
public class FruitsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private int quantityInStock;

    @Column
    private String fruitName;

    @ManyToMany
    @JoinTable(name = "TB_FRUITS_ACAI",
            joinColumns = @JoinColumn(name = "fruits_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "acai_to_delivery_id"))
    private Set<AcaiToDeliveryEntity> acaiToDeliveryEntities = new LinkedHashSet<>();

}
