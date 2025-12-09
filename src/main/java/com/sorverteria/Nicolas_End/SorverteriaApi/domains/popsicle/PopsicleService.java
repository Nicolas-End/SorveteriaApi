package com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
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

        if (popsicleRepository.findByFlavor(popsicleEntity.getFlavor()) != null) return ResponseEntity.status(HttpStatus.CONFLICT).body("Sabor ja cadastrado");

        popsicleRepository.save(popsicleEntity);

        return ResponseEntity.ok("Sorvete Cadastrado com sucesso");
    }

    public ResponseEntity getPopsicleById(UUID id){
        Optional popsicleDatas = popsicleRepository.findById(id);

        if (popsicleDatas.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok(popsicleDatas);

    }

    public ResponseEntity getAllPopsicle(){
        if (popsicleRepository.findAll().isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(popsicleRepository.findAll());
    }

    @Transactional
    public ResponseEntity dropPopsicle(UUID id){

        if(popsicleRepository.findById(id).isEmpty()) return ResponseEntity.notFound().build();


        popsicleRepository.deleteById(id);

        return ResponseEntity.ok("Sorvete Deletado");
    }


    public ResponseEntity updatePopsicleDatas(PopsicleEntity datas){
        if(this.popsicleRepository.findById(datas.getId()) == null ) return ResponseEntity.notFound().build();


        this.popsicleRepository.save(datas);

        return ResponseEntity.ok("informações atualizadas");

    }
}
