package com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle;

import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.popsicle.PopsicleDatasWithoutIdDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/popsicle")

public class PopsicleController {
    private final PopsicleService popsicleService;

    public PopsicleController(PopsicleService popsicleService){
        this.popsicleService = popsicleService;
    }

    @GetMapping
    public ResponseEntity getAllPopsicle(){
        return  this.popsicleService.getAllPopsicle();
    }

    @GetMapping("/{id}")
    public ResponseEntity getPopsicleById(@PathVariable UUID id){
        return this.popsicleService.getPopsicleById(id);
    }

    @PostMapping()
    public ResponseEntity registerNewPopsicle(@RequestBody PopsicleEntity datas){
        return this.popsicleService.registerNewPopsicle(datas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity dropPopsicleById(@PathVariable UUID id){
        return popsicleService.dropPopsicle(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePopsicleData(@PathVariable UUID id, @RequestBody PopsicleDatasWithoutIdDTO datas){
        return this.popsicleService.updatePopsicleDatas(id, datas);
    }
}
