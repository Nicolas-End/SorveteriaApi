package com.sorverteria.Nicolas_End.SorverteriaApi.repository;

import com.sorverteria.Nicolas_End.SorverteriaApi.entity.AccompanimentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccompanimentRepository extends JpaRepository<AccompanimentEntity, UUID> {
}
