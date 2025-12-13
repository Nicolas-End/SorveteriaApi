package com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits;


import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.FruitDatasWithoutIdDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.RequestNewFruitQuantityDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FruitsService {
    private final FruitsRepository fruitsRepository;

    public FruitsService(FruitsRepository fruitsRepository){
        this.fruitsRepository = fruitsRepository;
    }

    public ResponseEntity addNewFruit(FruitDatasWithoutIdDTO data){
        if(fruitsRepository.findByFruitName(data.fruitName()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Fruta já cadastrada no sistema");

        }

        FruitsEntity fruit = new FruitsEntity();

        fruit.setFruitName(data.fruitName());
        fruit.setQuantityInStock(data.quantityInStock());

        fruitsRepository.save(fruit);

        return ResponseEntity.ok("Fruta cadastrada");
    }

    public ResponseEntity updateFruitQuantity(UUID id, RequestNewFruitQuantityDTO data){
        FruitsEntity fruit = fruitsRepository.findById(id).orElse(null);

        if(fruit == null) return ResponseEntity.notFound().build();

        fruit.setQuantityInStock(data.quantity());

        fruitsRepository.save(fruit);

        return ResponseEntity.ok("Estoque de fruta atualizada");
    }

    public ResponseEntity getAllFruits(){
        List<FruitsEntity> fruits = fruitsRepository.findAll();

        if(fruits.isEmpty()) return ResponseEntity.ok("nenhuma fruta cadastrada");

        return ResponseEntity.ok(fruits);
    }

    public ResponseEntity getInfoFruitWithouIdAndAcais(UUID id){// n retona o id e nem os açais para entregar
        FruitsEntity fruit = fruitsRepository.findById(id).orElse(null);

        if(fruit == null) return ResponseEntity.notFound().build();

        FruitDatasWithoutIdDTO fruitWithoutId = new FruitDatasWithoutIdDTO(fruit.getQuantityInStock(),fruit.getFruitName());


        return ResponseEntity.ok(fruitWithoutId);
    }

    public ResponseEntity getInfoFruit(UUID id){// retorna todas as informações do pedido
        FruitsEntity fruit = fruitsRepository.findById(id).orElse(null);

        if(fruit == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(fruit);
    }

    @Transactional
    public ResponseEntity deleteFruit(UUID id){
        FruitsEntity fruit = fruitsRepository.findById(id).orElse(null);
        if (fruit == null) return ResponseEntity.notFound().build();

        fruitsRepository.delete(fruit);

        return ResponseEntity.ok("Fruta deletada com sucesso");
    }



}
