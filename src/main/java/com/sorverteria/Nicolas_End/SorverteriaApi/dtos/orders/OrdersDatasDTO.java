package com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.popsicle.PopsicleDatasWithoutIdDTO;

import java.util.UUID;

public record OrdersDatasDTO(UUID id,String flavor, double PriceByUnit, int quantityOrdered) {
}
