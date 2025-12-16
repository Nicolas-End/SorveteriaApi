package com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/popsicle")
public class PopsicleController {
    private final PopsicleService popsicleService;
    public PopsicleController(PopsicleService popsicleService){
        this.popsicleService = popsicleService;
    }

}
