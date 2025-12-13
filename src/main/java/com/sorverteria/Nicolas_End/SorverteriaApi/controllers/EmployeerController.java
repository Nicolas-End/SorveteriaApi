package com.sorverteria.Nicolas_End.SorverteriaApi.controllers;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits.FruitsService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.FruitDatasDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.popsicle.PopsicleDatasWithoutIdDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employeer")
public class EmployeerController {

    private final PopsicleService popsicleService;
    private final FruitsService fruitsService;

    public EmployeerController(PopsicleService popsicleService, FruitsService fruitsService){
        this.popsicleService = popsicleService;
        this.fruitsService = fruitsService;
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

    @PostMapping("/add-new-fruit")
    public ResponseEntity addNewFruit(@RequestBody FruitDatasDTO datas){
        return fruitsService.addNewFruit(datas);
    }
}
