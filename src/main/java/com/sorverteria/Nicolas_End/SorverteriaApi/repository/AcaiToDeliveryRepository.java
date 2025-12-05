package com.sorverteria.Nicolas_End.SorverteriaApi.repository;

import com.sorverteria.Nicolas_End.SorverteriaApi.entity.AcaiToDeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AcaiToDeliveryRepository extends JpaRepository<AcaiToDeliveryEntity, UUID> {
}
