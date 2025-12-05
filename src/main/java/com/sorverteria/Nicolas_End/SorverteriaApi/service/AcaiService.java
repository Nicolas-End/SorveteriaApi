package com.sorverteria.Nicolas_End.SorverteriaApi.service;

import com.sorverteria.Nicolas_End.SorverteriaApi.repository.AcaiToDeliveryRepository;
import org.springframework.stereotype.Service;

@Service
public class AcaiService {
    private final AcaiToDeliveryRepository acaiToDeliveryRepository;

    public AcaiService(AcaiToDeliveryRepository acaiToDeliveryRepository){
        this.acaiToDeliveryRepository = acaiToDeliveryRepository;
    }
}
