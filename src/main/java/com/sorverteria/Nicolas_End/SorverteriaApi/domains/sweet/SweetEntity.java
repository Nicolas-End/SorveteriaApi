package com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet;

import jakarta.persistence.*;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai.AcaiEntity;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Table(name="TB_SWEET")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SweetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;

    @Column
    private int quantityInStock;

    @ManyToMany(mappedBy = "sweet")
    private Set<AcaiEntity> acais = new LinkedHashSet<>();

}
