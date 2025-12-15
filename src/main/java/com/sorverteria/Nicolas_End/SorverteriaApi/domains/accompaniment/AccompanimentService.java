package com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai.AcaiRepository;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.NameAndQuantityDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.NameQuantityAndIdDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccompanimentService {
    private final AccompanimentRepository accompanimentRepository;

    public AccompanimentService(AccompanimentRepository accompanimentRepository, AcaiRepository acaiRepository){
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

    public ResponseEntity updateQuantity(UUID id, int quantityStock){
        AccompanimentEntity accompaniment = this.accompanimentRepository.findById(id).orElse(null);
        if(accompaniment == null ) return ResponseEntity.notFound().build();

        accompaniment.setQuantityInStock(quantityStock);
        this.accompanimentRepository.save(accompaniment);

        return ResponseEntity.ok("Quantidade de estoque atualizada");
    }

    public ResponseEntity getInfoAccompanimentToCostumer(UUID id){
        AccompanimentEntity accompaniment = this.accompanimentRepository.findById(id).orElse(null);
        if(accompaniment == null ) return ResponseEntity.notFound().build();

        NameAndQuantityDTO datas = new NameAndQuantityDTO(accompaniment.getQuantityInStock(), accompaniment.getName());

        return ResponseEntity.ok(datas);

    }

    public ResponseEntity getAllAccompaniment(){
        List<AccompanimentEntity> accompaniments = this.accompanimentRepository.findAll();
        if(accompaniments.isEmpty()) return ResponseEntity.notFound().build();

        List<NameQuantityAndIdDTO> datas = accompaniments.stream()
                .map(accompaniment -> new NameQuantityAndIdDTO(
                        accompaniment.getId(),
                        accompaniment.getName(),
                        accompaniment.getQuantityInStock()
                )).toList();

        return ResponseEntity.ok(datas);
    }

    public ResponseEntity deleteAccompaniment(UUID id){
        AccompanimentEntity accompaniment = this.accompanimentRepository.findById(id).orElse(null);
        if (accompaniment == null) return ResponseEntity.notFound().build();

        this.accompanimentRepository.delete(accompaniment);

        return ResponseEntity.ok("Deletado com sucesso");
    }

    public List<AccompanimentEntity> findManyByIds(List<UUID> accompanimentIds){
        return accompanimentRepository.findAllById(accompanimentIds);


    }

}
