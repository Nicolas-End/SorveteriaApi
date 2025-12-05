package com.sorverteria.Nicolas_End.SorverteriaApi.service;

import com.sorverteria.Nicolas_End.SorverteriaApi.repository.PopsicleRepository;
import org.springframework.stereotype.Service;

@Service
public class PopsicleService {
    private final PopsicleRepository popsicleRepository;

    public PopsicleService(PopsicleRepository popsicleRepository){
        this.popsicleRepository = popsicleRepository;
    }
}
