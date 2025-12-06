package com.sorverteria.Nicolas_End.SorverteriaApi.domain.popsicle;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.popsicle.PopsicleRepository;
import org.springframework.stereotype.Service;

@Service
public class PopsicleService {
    private final PopsicleRepository popsicleRepository;

    public PopsicleService(PopsicleRepository popsicleRepository){
        this.popsicleRepository = popsicleRepository;
    }
}
