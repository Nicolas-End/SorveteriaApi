package com.sorverteria.Nicolas_End.SorverteriaApi.dto;

import com.sorverteria.Nicolas_End.SorverteriaApi.enums.UserRole;


public record UserSummaryDTO (String email, String name, UserRole role, String cpf){
 // DTO para pegar os usuario cadastrados no sistema pelo Role
}
