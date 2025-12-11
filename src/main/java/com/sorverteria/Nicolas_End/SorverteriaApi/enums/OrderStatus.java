package com.sorverteria.Nicolas_End.SorverteriaApi.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {

    PENDENTE("PENDENTE"),
    PROCESSANDO("PROCESSANDO"),
    ENTREGUE("ENTREGUE");
    private final String status;

}
