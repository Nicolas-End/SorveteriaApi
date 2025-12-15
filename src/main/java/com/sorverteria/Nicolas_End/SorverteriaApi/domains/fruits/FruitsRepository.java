package com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment.AccompanimentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FruitsRepository extends JpaRepository<FruitsEntity, UUID> {
    FruitsEntity findByFruitName(String name);


}
