package com.sorverteria.Nicolas_End.SorverteriaApi.service;

import com.sorverteria.Nicolas_End.SorverteriaApi.repository.FruitsRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitsService {
    private final FruitsRepository fruitsRepository;

    public FruitsService(FruitsRepository fruitsRepository){
        this.fruitsRepository = fruitsRepository;
    }
}
