package com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet;

import jakarta.persistence.*;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai.AcaiToDeliveryEntity;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Table(name="TB_SWEET")
@Entity
@Data
public class SweetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;

    @Column
    private int quantityInStock;

    @ManyToMany
    @JoinTable(name = "TB_SWEET_ACAI",
            joinColumns = @JoinColumn(name = "sweet_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "acai_to_delivery_id"))
    private Set<AcaiToDeliveryEntity> acaiToDeliveryEntities = new LinkedHashSet<>();

}
