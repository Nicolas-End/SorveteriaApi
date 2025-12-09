package com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai;

import org.springframework.stereotype.Service;

@Service
public class AcaiService {
    private final AcaiToDeliveryRepository acaiToDeliveryRepository;

    public AcaiService(AcaiToDeliveryRepository acaiToDeliveryRepository){
        this.acaiToDeliveryRepository = acaiToDeliveryRepository;
    }
}
