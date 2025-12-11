package com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders;

import com.sorverteria.Nicolas_End.SorverteriaApi.enums.OrderStatus;

public record RequestNewStatusDTO (OrderStatus newStatus){
}
