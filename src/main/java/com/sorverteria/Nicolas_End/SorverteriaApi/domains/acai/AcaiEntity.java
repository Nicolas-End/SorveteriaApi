package com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment.AccompanimentEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits.FruitsEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet.SweetEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.enums.AcaiSize;
import jakarta.persistence.*;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.user.UserEntity;
import lombok.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="TB_ACAI_TO_DELIVERY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcaiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcaiSize size;

    @Column(nullable = false)
    private double price;


    @ManyToMany
    @JoinTable(
            name = "TB_ACCOMPANIMENT_ACAI",
            joinColumns = @JoinColumn(name="acai_id"), // ID dessa entidade
            inverseJoinColumns = @JoinColumn(name="accompaniment_id")    // ID da outra entidade
    )
    private Set<AccompanimentEntity> accompaniment = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "TB_FRUITS_ACAI",

            joinColumns = @JoinColumn(name = "acai_id"),
            inverseJoinColumns = @JoinColumn(name = "fruits_entity_id"))
    private Set<FruitsEntity> fruits  = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "TB_SWEET_ACAI",
            joinColumns = @JoinColumn(name = "acai_id"),
            inverseJoinColumns = @JoinColumn(name = "sweet_entity_id"))
    private Set<SweetEntity> sweet = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private UserEntity user;
}
