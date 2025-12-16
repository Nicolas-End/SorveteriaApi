package com.sorverteria.Nicolas_End.SorverteriaApi.controllers;


import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.NameAndQuantityDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.QuantityDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.popsicle.PopsicleDatasWithoutIdDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employeer")
public class EmployeerController {

    private final PopsicleService popsicleService;

    public EmployeerController(PopsicleService popsicleService){
        this.popsicleService = popsicleService;


    }

    @GetMapping
    public String hello(){
        return "Hello to the Employeer Page";
    }


    @PostMapping("/register-new-popsicle")
    public ResponseEntity registerNewPopsicle(@RequestBody PopsicleEntity datas){
        return this.popsicleService.registerNewPopsicle(datas);
    }
    @PostMapping("/update-popsicle-datas/{id}")
    public ResponseEntity updatePopsicleData(@PathVariable UUID id, @RequestBody PopsicleDatasWithoutIdDTO datas){
        return this.popsicleService.updatePopsicleDatas(id, datas);
    }
    @DeleteMapping("/delete-popsicle/{id}")
    public ResponseEntity dropPopsicleById(@PathVariable UUID id){
        return popsicleService.dropPopsicle(id);
    }




}
