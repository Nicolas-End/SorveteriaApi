package com.sorverteria.Nicolas_End.SorverteriaApi.domain.sweet;

import jakarta.persistence.*;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.acai.AcaiToDeliveryEntity;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Table(name="TB_SWEET")
@Entity
public class SweetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private int quantityInStock;

    @ManyToMany
    @JoinTable(name = "TB_SWEET_ACAI",
            joinColumns = @JoinColumn(name = "sweet_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "acai_to_delivery_id"))
    private Set<AcaiToDeliveryEntity> acaiToDeliveryEntities = new LinkedHashSet<>();

}
