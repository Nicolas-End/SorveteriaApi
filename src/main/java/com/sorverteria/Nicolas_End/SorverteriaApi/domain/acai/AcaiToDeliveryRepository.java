package com.sorverteria.Nicolas_End.SorverteriaApi.domain.acai;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.acai.AcaiToDeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AcaiToDeliveryRepository extends JpaRepository<AcaiToDeliveryEntity, UUID> {
}
