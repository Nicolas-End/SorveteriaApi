package com.sorverteria.Nicolas_End.SorverteriaApi.domain.popsicle;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.popsicle.PopsicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PopsicleRepository extends JpaRepository<PopsicleEntity, UUID> {
}