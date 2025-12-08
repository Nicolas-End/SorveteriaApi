package com.sorverteria.Nicolas_End.SorverteriaApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeer")
public class EmployeerController {

    @GetMapping
    public String hello(){
        return "Hello to the Employeer Page";
    }
}
