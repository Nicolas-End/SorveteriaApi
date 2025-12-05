package com.sorverteria.Nicolas_End.SorverteriaApi.entity;

import com.sorverteria.Nicolas_End.SorverteriaApi.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="TB_USERS")
@Data
public class UserEntity {

    @Id
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true , unique = true)
    private int cpf;

    @Column(nullable = false,unique = false)
    private String password;

    @Column(nullable = false,unique = false)
    private RoleEnum roleEnum;
}
