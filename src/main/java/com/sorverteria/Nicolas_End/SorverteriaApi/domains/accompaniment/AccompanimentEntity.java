package com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai.AcaiToDeliveryEntity;
import lombok.Data;

@Table(name="TB_ACCOMPANIMENTS")
@Entity
@Data
public class AccompanimentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column
    private int QuantityInStock;

    @ManyToMany
    @JoinTable(
            name = "TB_ACCOMPANIMENT_ACAI",
            joinColumns = @JoinColumn(name="accompaniment_id"), // ID dessa entidade
            inverseJoinColumns = @JoinColumn(name="acai_id")    // ID da outra entidade
    )
    private Set<AcaiToDeliveryEntity> acai = new HashSet<>();


}
