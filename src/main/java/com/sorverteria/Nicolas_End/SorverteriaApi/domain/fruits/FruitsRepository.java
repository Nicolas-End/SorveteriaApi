package com.sorverteria.Nicolas_End.SorverteriaApi.domain.fruits;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.fruits.FruitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FruitsRepository extends JpaRepository<FruitsEntity, UUID> {
}
