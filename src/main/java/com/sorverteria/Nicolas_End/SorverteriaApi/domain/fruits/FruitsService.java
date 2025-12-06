package com.sorverteria.Nicolas_End.SorverteriaApi.domain.fruits;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.fruits.FruitsRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitsService {
    private final FruitsRepository fruitsRepository;

    public FruitsService(FruitsRepository fruitsRepository){
        this.fruitsRepository = fruitsRepository;
    }
}
