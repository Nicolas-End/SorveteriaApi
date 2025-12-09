package com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits;

import org.springframework.stereotype.Service;

@Service
public class FruitsService {
    private final FruitsRepository fruitsRepository;

    public FruitsService(FruitsRepository fruitsRepository){
        this.fruitsRepository = fruitsRepository;
    }
}
