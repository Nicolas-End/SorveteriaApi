package com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SweetRepository extends JpaRepository<SweetEntity, UUID> {
}
