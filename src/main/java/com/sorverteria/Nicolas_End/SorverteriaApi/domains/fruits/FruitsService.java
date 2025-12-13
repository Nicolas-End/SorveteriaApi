package com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits;


import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.FruitDatasDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FruitsService {
    private final FruitsRepository fruitsRepository;

    public FruitsService(FruitsRepository fruitsRepository){
        this.fruitsRepository = fruitsRepository;
    }

    public ResponseEntity addNewFruit(FruitDatasDTO data){
        if(fruitsRepository.findByFruitName(data.fruitName()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Fruta já cadastrada no sistema");

        }

        FruitsEntity fruit = new FruitsEntity();

        fruit.setFruitName(data.fruitName());
        fruit.setQuantityInStock(data.quantityInStock());

        fruitsRepository.save(fruit);

        return ResponseEntity.ok("Fruta cadastrada");
    }
}
