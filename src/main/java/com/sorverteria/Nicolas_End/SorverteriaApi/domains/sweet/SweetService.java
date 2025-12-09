package com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet;

import org.springframework.stereotype.Service;

@Service
public class SweetService {
    private final SweetRepository sweetRepository;

    public SweetService(SweetRepository sweetRepository){
        this.sweetRepository = sweetRepository;
    }
}
