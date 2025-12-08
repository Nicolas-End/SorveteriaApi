package com.sorverteria.Nicolas_End.SorverteriaApi.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    ADMIN("ADMIN"),
    EMPLOYEER("EMPLOYEER"),
    COSTUMER("COSTUMER");
    private final String role;
}
