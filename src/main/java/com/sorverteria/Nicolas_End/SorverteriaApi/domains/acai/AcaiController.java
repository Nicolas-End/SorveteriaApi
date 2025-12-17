package com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/açai")
public class AcaiController {

    @GetMapping
    public ResponseEntity getAllMyAcai(){
        return ResponseEntity.ok("Ta suave");
    }

}
