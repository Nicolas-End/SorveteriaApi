package com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PopsicleRepository extends JpaRepository<PopsicleEntity, UUID> {

    PopsicleEntity findByFlavor(String flavor);

}