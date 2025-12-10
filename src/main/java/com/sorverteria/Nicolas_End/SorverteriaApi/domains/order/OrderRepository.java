package com.sorverteria.Nicolas_End.SorverteriaApi.domains.order;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.user.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    List<OrderEntity> findByUser(UserEntity user);
}