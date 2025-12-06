package com.sorverteria.Nicolas_End.SorverteriaApi.domain.sweet;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.sweet.SweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SweetRepository extends JpaRepository<SweetEntity, UUID> {
}
