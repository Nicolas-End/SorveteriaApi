package com.sorverteria.Nicolas_End.SorverteriaApi.share.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    ADMIN("ADMIN"),
    EMPLOYEE("EMPLOYEE"),
    COSTUMER("COSTUMER");
    private final String role;
}
