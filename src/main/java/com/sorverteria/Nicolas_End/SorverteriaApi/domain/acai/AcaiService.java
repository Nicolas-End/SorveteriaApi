package com.sorverteria.Nicolas_End.SorverteriaApi.domain.acai;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.acai.AcaiToDeliveryRepository;
import org.springframework.stereotype.Service;

@Service
public class AcaiService {
    private final AcaiToDeliveryRepository acaiToDeliveryRepository;

    public AcaiService(AcaiToDeliveryRepository acaiToDeliveryRepository){
        this.acaiToDeliveryRepository = acaiToDeliveryRepository;
    }
}
