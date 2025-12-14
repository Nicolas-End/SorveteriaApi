package com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccompanimentRepository extends JpaRepository<AccompanimentEntity, UUID> {
    AccompanimentEntity findByName(String name);


}
