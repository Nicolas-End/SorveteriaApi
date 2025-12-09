package com.sorverteria.Nicolas_End.SorverteriaApi.controllers;


import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.popsicle.RequestPopsicleIdDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    private final PopsicleService popsicleService;
    public  CostumerController(PopsicleService popsicleService){
        this.popsicleService = popsicleService;
    }

    @GetMapping
    public String hello (){
        return "Hello to the costumer Page";
    }

    @PostMapping("/get-popsicle-by-id/{id}")
    public ResponseEntity getPopsicleById(@PathVariable UUID id){
        return this.popsicleService.getPopsicleById(id);
    }

    @PostMapping("/get-popsicles")
    public ResponseEntity getAllPopsicle(){
        return  this.popsicleService.getAllPopsicle();
    }
}
