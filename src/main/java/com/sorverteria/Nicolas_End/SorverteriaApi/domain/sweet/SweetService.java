package com.sorverteria.Nicolas_End.SorverteriaApi.domain.sweet;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.sweet.SweetRepository;
import org.springframework.stereotype.Service;

@Service
public class SweetService {
    private final SweetRepository sweetRepository;

    public SweetService(SweetRepository sweetRepository){
        this.sweetRepository = sweetRepository;
    }
}
