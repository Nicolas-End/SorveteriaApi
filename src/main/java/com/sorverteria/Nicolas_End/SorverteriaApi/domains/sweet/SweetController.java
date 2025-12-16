package com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet;

import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.NameAndQuantityDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.QuantityDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sweet")
public class SweetController {
    private final SweetService sweetService;
    public SweetController(SweetService sweetService){
        this.sweetService = sweetService;
    }

    @GetMapping
    public ResponseEntity getAllSweet(){
        return this.sweetService.getAllSweets();
    }
    @GetMapping("/{id}")
    public ResponseEntity getSweetInfo(@PathVariable UUID id){
        return this.sweetService.getSweetInfoToCustomer(id);
    }


    @PostMapping
    public ResponseEntity addNewSweet(@RequestBody NameAndQuantityDTO data){
        return this.sweetService.addNewSweet(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSweet(@PathVariable UUID id){
        return this.sweetService.deleteSweet(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSweetQuantity(@PathVariable UUID id, @RequestBody QuantityDTO data){
        return this.sweetService.updateSweetQuantity(id, data.quantity());
    }
}
