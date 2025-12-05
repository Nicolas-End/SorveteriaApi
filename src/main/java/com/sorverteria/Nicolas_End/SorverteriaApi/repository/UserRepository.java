package com.sorverteria.Nicolas_End.SorverteriaApi.repository;

import com.sorverteria.Nicolas_End.SorverteriaApi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}