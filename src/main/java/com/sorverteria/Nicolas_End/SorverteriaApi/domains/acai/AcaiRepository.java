package com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AcaiRepository extends JpaRepository<AcaiEntity, UUID> {
}
