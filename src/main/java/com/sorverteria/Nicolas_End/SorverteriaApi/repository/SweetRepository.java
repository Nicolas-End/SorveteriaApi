package com.sorverteria.Nicolas_End.SorverteriaApi.repository;

import com.sorverteria.Nicolas_End.SorverteriaApi.entity.SweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SweetRepository extends JpaRepository<SweetEntity, UUID> {
}
