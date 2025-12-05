package com.sorverteria.Nicolas_End.SorverteriaApi.repository;

import com.sorverteria.Nicolas_End.SorverteriaApi.entity.PopsicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PopsicleRepository extends JpaRepository<PopsicleEntity, UUID> {
}