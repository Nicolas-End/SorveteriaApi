package com.sorverteria.Nicolas_End.SorverteriaApi.domain.accompaniment;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.accompaniment.AccompanimentRepository;
import org.springframework.stereotype.Service;

@Service
public class AccompanimentService {
    private final AccompanimentRepository accompanimentRepository;

    public AccompanimentService(AccompanimentRepository accompanimentRepository){
        this.accompanimentRepository = accompanimentRepository;
    }
}
