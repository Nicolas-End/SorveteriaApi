package com.sorverteria.Nicolas_End.SorverteriaApi.controllers;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.user.UserService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.user.UserSummaryDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.user.RegisterDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.enums.UserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public String hello(){
        return "Hello to the Admin Page";
    }

    @PostMapping("/add-new-employeer")
    public ResponseEntity registerEmployeer(@RequestBody RegisterDTO data){

        return userService.register(data, UserRole.EMPLOYEER);
    }

    @GetMapping("/get-employeers")
    public ArrayList<UserSummaryDTO> getEmployeers(){
        // retorna todos os employers cadastrados no sistemas
        return userService.getUsersByRole(UserRole.EMPLOYEER);
    }

    @DeleteMapping("/drop-employeer/{email}")
    public ResponseEntity deleteEmployeers(@PathVariable String email){
        // exclui o funcionario do banco de dados
        return userService.dropEmployeer(email);
    }

}
