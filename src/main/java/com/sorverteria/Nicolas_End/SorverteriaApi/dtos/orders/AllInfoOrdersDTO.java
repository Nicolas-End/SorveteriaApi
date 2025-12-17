package com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders;

import com.sorverteria.Nicolas_End.SorverteriaApi.enums.OrderStatus;

import java.util.UUID;

public record AllInfoOrdersDTO (UUID id, OrderStatus status, String flavor, double PriceByUnit, int quantityOrdered, String userName, String userEmail){
}
