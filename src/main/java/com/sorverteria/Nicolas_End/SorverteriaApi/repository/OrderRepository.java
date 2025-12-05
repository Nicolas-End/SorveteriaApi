package com.sorverteria.Nicolas_End.SorverteriaApi.repository;

import com.sorverteria.Nicolas_End.SorverteriaApi.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}