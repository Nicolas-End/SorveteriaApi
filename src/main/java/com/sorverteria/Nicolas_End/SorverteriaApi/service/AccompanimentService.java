package com.sorverteria.Nicolas_End.SorverteriaApi.service;

import com.sorverteria.Nicolas_End.SorverteriaApi.repository.AccompanimentRepository;
import org.springframework.stereotype.Service;

@Service
public class AccompanimentService {
    private final AccompanimentRepository accompanimentRepository;

    public AccompanimentService(AccompanimentRepository accompanimentRepository){
        this.accompanimentRepository = accompanimentRepository;
    }
}
