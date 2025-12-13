package com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SweetRepository extends JpaRepository<SweetEntity, UUID> {
}
