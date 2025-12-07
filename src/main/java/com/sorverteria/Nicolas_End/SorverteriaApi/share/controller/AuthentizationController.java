package com.sorverteria.Nicolas_End.SorverteriaApi.share.controller;


import com.sorverteria.Nicolas_End.SorverteriaApi.domain.authorization.AuthorizationService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.AuthenticationDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.RegisterDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.UserRepository;
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

    public AuthentizationController(AuthenticationManager authenticationManager, AuthorizationService authorizationService){
        this.authenticationManager = authenticationManager;
        this.authorizationService = authorizationService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data){
        var usenamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usenamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity login(@RequestBody RegisterDTO data ){
        return authorizationService.login(data);
    }
}
