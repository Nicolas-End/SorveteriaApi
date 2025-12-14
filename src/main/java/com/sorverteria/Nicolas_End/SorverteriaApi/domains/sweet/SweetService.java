package com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet;

import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.NameAndQuantityDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.NameQuantityAndIdDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SweetService {
    private final SweetRepository sweetRepository;

    public SweetService(SweetRepository sweetRepository){
        this.sweetRepository = sweetRepository;
    }

    public ResponseEntity addNewSweet(NameAndQuantityDTO sweet){
        if (sweetRepository.findByName(sweet.name()) != null)
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Doce já cadastrado");

        SweetEntity newSweet = new SweetEntity();
        newSweet.setName(sweet.name());
        newSweet.setQuantityInStock(sweet.quantityInStock());

        this.sweetRepository.save(newSweet);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity updateSweetQuantity(UUID id, int quantityStock){
        SweetEntity sweet = this.sweetRepository.findById(id).orElse(null);
        if (sweet == null)
            return ResponseEntity.notFound().build();

        sweet.setQuantityInStock(quantityStock);
        this.sweetRepository.save(sweet);

        return ResponseEntity.ok("Quantidade de estoque atualizada");
    }

    public ResponseEntity getSweetInfoToCustomer(UUID id){
        SweetEntity sweet = this.sweetRepository.findById(id).orElse(null);
        if (sweet == null)
            return ResponseEntity.notFound().build();

        NameAndQuantityDTO datas =
                new NameAndQuantityDTO(
                        sweet.getQuantityInStock(),
                        sweet.getName()
                );

        return ResponseEntity.ok(datas);
    }

    public ResponseEntity getAllSweets(){
        List<SweetEntity> sweets = this.sweetRepository.findAll();
        if (sweets.isEmpty())
            return ResponseEntity.notFound().build();

        List<NameQuantityAndIdDTO> datas = sweets.stream()
                .map(sweet -> new NameQuantityAndIdDTO(
                        sweet.getId(),
                        sweet.getName(),
                        sweet.getQuantityInStock()
                ))
                .toList();

        return ResponseEntity.ok(datas);
    }

    public ResponseEntity deleteSweet(UUID id){
        SweetEntity sweet = this.sweetRepository.findById(id).orElse(null);
        if (sweet == null)
            return ResponseEntity.notFound().build();

        this.sweetRepository.delete(sweet);

        return ResponseEntity.ok("Deletado com sucesso");
    }



}
