package com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders;

import java.util.UUID;

    public record RequestOrderWithOutIdDTO(int quantityOrdered, UUID popsicleId) {
}
