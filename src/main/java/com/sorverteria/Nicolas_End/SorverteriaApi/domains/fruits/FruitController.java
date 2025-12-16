package com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits;

import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.NameAndQuantityDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.QuantityDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/fruit")
public class FruitController {
    private final FruitsService fruitsService;
    public FruitController(FruitsService fruitsService){
        this.fruitsService = fruitsService;
    }

    @GetMapping
    public ResponseEntity getAllFruits(){
        return this.fruitsService.getAllFruits();
    }

    @GetMapping("/{id}")
    public ResponseEntity getInfoFruit(@PathVariable UUID id){
        return this.fruitsService.getInfoFruits(id);
    }


    @PostMapping
    public ResponseEntity addNewFruit(@RequestBody NameAndQuantityDTO datas){
        return fruitsService.addNewFruit(datas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFruit(@PathVariable UUID id){
        return this.fruitsService.deleteFruit(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateFruitQuantity(@PathVariable UUID id, @RequestBody QuantityDTO data){
        return fruitsService.updateFruitQuantity(id, data);
    }

}
