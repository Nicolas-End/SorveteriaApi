package com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai;

import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.AcaiDataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/acai")
public class AcaiController {

    private final AcaiService acaiService;

    public AcaiController(AcaiService acaiService) {
        this.acaiService = acaiService;
    }

    @GetMapping
    public ResponseEntity getAllMyAcai() {
        return acaiService.getAllMyAcai();
    }

    @GetMapping("/{id}")
    public ResponseEntity getEspecificAcai(@PathVariable UUID id){
        return acaiService.getMyEspecificAcai(id);
    }

    @PostMapping
    public ResponseEntity requestNewAcai(@RequestBody AcaiDataDTO data) {
        return acaiService.addNewAcai(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateEspecificAcai(@PathVariable UUID id,@RequestBody AcaiDataDTO datas){
        return acaiService.updateAcaiDatas(id,datas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAcaiOrder(@PathVariable UUID id){
        return acaiService.deleteMyAcaiOrder(id);
    }
}

