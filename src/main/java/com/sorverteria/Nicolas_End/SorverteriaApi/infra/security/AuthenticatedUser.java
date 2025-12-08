package com.sorverteria.Nicolas_End.SorverteriaApi.infra.security;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.UserEntity;
import jakarta.persistence.Entity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUser {
    // clase para pegar as informações do usuario durante o contexot do sistema
    public UserEntity get(){
        return (UserEntity) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
