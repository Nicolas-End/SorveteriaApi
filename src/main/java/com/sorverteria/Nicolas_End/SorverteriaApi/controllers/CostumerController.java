package com.sorverteria.Nicolas_End.SorverteriaApi.controllers;


import com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai.AcaiService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.AcaiDataDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    private final AcaiService acaiService;

    public  CostumerController( AcaiService acaiService){
        this.acaiService = acaiService;
    }

    @GetMapping
    public String hello (){
        return "Hello to the costumer Page";
    }





    @RequestMapping("/açai")
    public class AcaiSession{
        @PostMapping
        public ResponseEntity requestNewAcai(@RequestBody AcaiDataDTO data){
            return acaiService.addNewAcai(data);
        }
    }
}
