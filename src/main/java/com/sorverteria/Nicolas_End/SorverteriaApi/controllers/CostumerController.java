package com.sorverteria.Nicolas_End.SorverteriaApi.controllers;



import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    @GetMapping
    public String hello (){
        return "Hello to the costumer Page";
    }



}
