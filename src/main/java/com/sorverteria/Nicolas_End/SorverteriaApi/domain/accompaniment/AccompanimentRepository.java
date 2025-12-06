package com.sorverteria.Nicolas_End.SorverteriaApi.domain.accompaniment;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.accompaniment.AccompanimentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccompanimentRepository extends JpaRepository<AccompanimentEntity, UUID> {
}
