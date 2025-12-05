package com.sorverteria.Nicolas_End.SorverteriaApi.service;

import com.sorverteria.Nicolas_End.SorverteriaApi.repository.SweetRepository;
import org.springframework.stereotype.Service;

@Service
public class SweetService {
    private final SweetRepository sweetRepository;

    public SweetService(SweetRepository sweetRepository){
        this.sweetRepository = sweetRepository;
    }
}
