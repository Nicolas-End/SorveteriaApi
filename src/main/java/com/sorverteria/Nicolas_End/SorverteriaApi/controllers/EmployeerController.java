package com.sorverteria.Nicolas_End.SorverteriaApi.controllers;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment.AccompanimentService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits.FruitsService;
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
    private final FruitsService fruitsService;
    private final AccompanimentService accompanimentService;

    public EmployeerController(PopsicleService popsicleService, FruitsService fruitsService, AccompanimentService accompanimentService){
        this.popsicleService = popsicleService;
        this.fruitsService = fruitsService;
        this.accompanimentService = accompanimentService;
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



    @DeleteMapping("/delete-fruit/{id}")
    public ResponseEntity deleteFruit(@PathVariable UUID id){
        return this.fruitsService.deleteFruit(id);
    }

    @PostMapping("/add-new-fruit")
    public ResponseEntity addNewFruit(@RequestBody NameAndQuantityDTO datas){
        return fruitsService.addNewFruit(datas);
    }

    @PostMapping("/update-fruit-quantity/{id}")
    public ResponseEntity updateFruitQuantity(@PathVariable UUID id, @RequestBody QuantityDTO data){
        return fruitsService.updateFruitQuantity(id, data);
    }

    @GetMapping("/get-fruit-all-info/{id}")
    public ResponseEntity getAllFruitInfo(@PathVariable UUID id){
        return fruitsService.getInfoFruit(id);
    }


    @PostMapping("/add-new-accompaniment")
    public ResponseEntity addNewAccompaniment(@RequestBody NameAndQuantityDTO accompaniment){
        return this.accompanimentService.addNewAccompaniment(accompaniment);
    }

    @PostMapping("/update-quantity-accompaniment/{id}")
    public ResponseEntity updateAccompanimentQuantity(@RequestBody QuantityDTO data, @PathVariable UUID id){
        return this.accompanimentService.updateQuantity(id, data.quantity());
    }

    @DeleteMapping("/delete-accompaniment/{id}")
    public ResponseEntity deleteAccompaniment(@PathVariable UUID id){
        return this.accompanimentService.deleteAccompaniment(id);
    }

}
