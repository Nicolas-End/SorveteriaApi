package com.sorverteria.Nicolas_End.SorverteriaApi.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AcaiSizeEnum {
    BIG("500ML"),
    MEDIUM("400ML"),
    SMALL("300ML");
    private final String size;
}
