package com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PopsicleService {
    private final PopsicleRepository popsicleRepository;

    public PopsicleService(PopsicleRepository popsicleRepository){
        this.popsicleRepository = popsicleRepository;
    }

    public ResponseEntity registerNewPopsicle(PopsicleEntity popsicleEntity){
        if (popsicleRepository.findByFlavor(popsicleEntity.getFlavor()) != null) return ResponseEntity.badRequest().build();
        popsicleRepository.save(popsicleEntity);
        return ResponseEntity.ok("Sorvete Cadastrado com sucesso");
    }

    public ResponseEntity getPopsicleById(UUID id){
        Optional popsicleDatas = popsicleRepository.findById(id);

        if (popsicleDatas == null){
            return ResponseEntity.badRequest().build();
        }

        return  ResponseEntity.ok(popsicleDatas);

    }

    public ResponseEntity getAllPopsicle(){
        if (popsicleRepository.findAll() == null ) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(popsicleRepository.findAll());
    }

    @Transactional
    public ResponseEntity dropPopsicle(UUID id){

        if(popsicleRepository.findById(id) == null) return ResponseEntity.badRequest().build();

        popsicleRepository.deleteById(id);

        return ResponseEntity.ok("Sorvete Deletado");
    }
}
