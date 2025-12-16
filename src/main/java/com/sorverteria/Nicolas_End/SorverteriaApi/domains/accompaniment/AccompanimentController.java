package com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment;


import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.NameAndQuantityDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.QuantityDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/accompaniment")
public class AccompanimentController {
    private final AccompanimentService accompanimentService;
    public AccompanimentController(AccompanimentService accompanimentService){
        this.accompanimentService = accompanimentService;
    }

    // costumer
    @GetMapping()
    public ResponseEntity getAllAccompaniment() {
        return this.accompanimentService.getAllAccompaniment();
    }
    @GetMapping("/{id}")
    public ResponseEntity getInfoAccompaniment(@PathVariable UUID id){
        return this.accompanimentService.getInfoAccompanimentToCostumer(id);
    }

    //employeer
    @PostMapping()
    public ResponseEntity addNewAccompaniment(@RequestBody NameAndQuantityDTO accompaniment){
        return this.accompanimentService.addNewAccompaniment(accompaniment);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAccompanimentQuantity(@RequestBody QuantityDTO data, @PathVariable UUID id){
        return this.accompanimentService.updateQuantity(id, data.quantity());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccompaniment(@PathVariable UUID id){
        return this.accompanimentService.deleteAccompaniment(id);
    }
}
