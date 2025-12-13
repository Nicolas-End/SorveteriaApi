package com.sorverteria.Nicolas_End.SorverteriaApi.controllers;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.user.UserService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.user.RequestNewCpfDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {// aqui o usuario podera mudar suas informações
    // criei esse controller para facilitar na manutenção e organização do projeto

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String hello (){
        return "Hello to the costumer Page";
    }


    @PostMapping("/update-own-cpf")
    public ResponseEntity UpdateOwnCpf(@RequestBody RequestNewCpfDTO data){
        return userService.updateUserCpf(data);
    }
}
