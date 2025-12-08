package com.sorverteria.Nicolas_End.SorverteriaApi.controller;


import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.UserService;
import com.sorverteria.Nicolas_End.SorverteriaApi.enums.UserRole;
import com.sorverteria.Nicolas_End.SorverteriaApi.infra.security.AuthorizationService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dto.LoginResponseDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dto.AuthenticationDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dto.RegisterDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.UserEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.infra.security.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthentizationController {


    private final UserService userService;


    public AuthentizationController(AuthenticationManager authenticationManager, UserService userService, AuthorizationService authorizationService, TokenService tokenService){
        this.userService = userService;

    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data){
        return userService.login(data);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO data ){
        return userService.register(data, UserRole.COSTUMER);
    }
}
