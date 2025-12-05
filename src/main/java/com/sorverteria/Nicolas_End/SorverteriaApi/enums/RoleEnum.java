package com.sorverteria.Nicolas_End.SorverteriaApi.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleEnum {
    BOSS("BOSS"),
    EMPLOYEE("EMPLOYEE"),
    COSTUMER("COSTUMER");
    private final String role;
}
