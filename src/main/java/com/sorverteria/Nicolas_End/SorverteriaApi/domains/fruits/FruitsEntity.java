package com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits;

import jakarta.persistence.*;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai.AcaiEntity;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "TB_FRUITS")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FruitsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private int quantityInStock;

    @Column
    private String fruitName;

    @ManyToMany(mappedBy = "fruits")
    private Set<AcaiEntity> acais = new LinkedHashSet<>();

}
