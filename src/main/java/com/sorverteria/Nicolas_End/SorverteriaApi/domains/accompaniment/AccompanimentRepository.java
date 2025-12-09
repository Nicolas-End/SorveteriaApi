package com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccompanimentRepository extends JpaRepository<AccompanimentEntity, UUID> {
}
