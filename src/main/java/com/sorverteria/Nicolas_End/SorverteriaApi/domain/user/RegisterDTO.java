package com.sorverteria.Nicolas_End.SorverteriaApi.domain.user;

import com.sorverteria.Nicolas_End.SorverteriaApi.share.enums.UserRole;

public record RegisterDTO(String email, String password, UserRole role, String name) {
}
