package com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment;

import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.NameAndQuantityDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccompanimentService {
    private final AccompanimentRepository accompanimentRepository;

    public AccompanimentService(AccompanimentRepository accompanimentRepository){
        this.accompanimentRepository = accompanimentRepository;
    }

    public ResponseEntity addNewAccompaniment(NameAndQuantityDTO accompaniment){
        if(accompanimentRepository.findByName(accompaniment.name()) != null) return ResponseEntity.status(HttpStatus.CONFLICT).body("Acompanhamento já cadastrado");

        AccompanimentEntity newAccompaniment = new AccompanimentEntity();
        newAccompaniment.setName(accompaniment.name());
        newAccompaniment.setQuantityInStock(accompaniment.quantityInStock());

        this.accompanimentRepository.save(newAccompaniment);
        return ResponseEntity.ok().build();
    }
}
