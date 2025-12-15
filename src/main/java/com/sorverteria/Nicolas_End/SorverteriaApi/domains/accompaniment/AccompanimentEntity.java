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

    @ManyToMany(mappedBy = "accompaniment")// lado dominado pelo açai
    private Set<AcaiToDeliveryEntity> acais = new HashSet<>();


}
