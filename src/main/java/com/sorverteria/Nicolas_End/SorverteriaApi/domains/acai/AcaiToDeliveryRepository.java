package com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AcaiToDeliveryRepository extends JpaRepository<AcaiToDeliveryEntity, UUID> {
}
