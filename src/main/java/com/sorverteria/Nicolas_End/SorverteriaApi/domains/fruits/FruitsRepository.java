package com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FruitsRepository extends JpaRepository<FruitsEntity, UUID> {
    FruitsEntity findByFruitName(String name);
}
