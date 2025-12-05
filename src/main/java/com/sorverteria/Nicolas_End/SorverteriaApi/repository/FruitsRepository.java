package com.sorverteria.Nicolas_End.SorverteriaApi.repository;

import com.sorverteria.Nicolas_End.SorverteriaApi.entity.FruitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FruitsRepository extends JpaRepository<FruitsEntity, UUID> {
}
