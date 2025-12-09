package com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai;

import com.sorverteria.Nicolas_End.SorverteriaApi.enums.AcaiSize;
import jakarta.persistence.*;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.user.UserEntity;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="TB_ACAI_TO_DELIVERY")
public class AcaiToDeliveryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private AcaiSize size;

    @Column(nullable = false)
    private double price;


    @ManyToMany
    @JoinTable(
            name = "TB_ACAI_USERS",
            joinColumns = @JoinColumn(name = "acai_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<UserEntity> users = new HashSet<>();
}
