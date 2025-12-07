package com.sorverteria.Nicolas_End.SorverteriaApi.share.controller;


import com.sorverteria.Nicolas_End.SorverteriaApi.domain.authorization.AuthorizationService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.authorization.LoginResponseDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.AuthenticationDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.RegisterDTO;
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

    private final AuthenticationManager authenticationManager;
    private final AuthorizationService authorizationService;
    private final TokenService tokenService;
    public AuthentizationController(AuthenticationManager authenticationManager, AuthorizationService authorizationService, TokenService tokenService){
        this.authenticationManager = authenticationManager;
        this.authorizationService = authorizationService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data){
        var usenamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usenamePassword);

        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO data ){
        return authorizationService.register(data);
    }
}
