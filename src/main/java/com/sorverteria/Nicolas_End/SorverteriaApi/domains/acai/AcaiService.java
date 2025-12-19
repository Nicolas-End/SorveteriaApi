package com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment.AccompanimentEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment.AccompanimentService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits.FruitsEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits.FruitsService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet.SweetEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet.SweetService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.AcaiDataDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.AcaiDatasToCostumerDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.FruitSweetAccomp.FSAFormatDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.FruitSweetAccomp.FSAListDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.enums.AcaiSize;
import com.sorverteria.Nicolas_End.SorverteriaApi.infra.security.AuthenticatedUser;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AcaiService {
    private final AcaiRepository acaiRepository;
    private final AccompanimentService accompanimentService;
    private final SweetService sweetService;
    private final FruitsService fruitsService;
    private final AuthenticatedUser authUser;
    public AcaiService( AccompanimentService accompanimentService, SweetService sweetService, FruitsService fruitsService, AuthenticatedUser authUser, AcaiRepository acaiRepository){
        this.acaiRepository = acaiRepository;
        this.accompanimentService = accompanimentService;
        this.sweetService = sweetService;
        this.fruitsService = fruitsService;
        this.authUser = authUser;
    }

    @Transactional
    public ResponseEntity addNewAcai(AcaiDataDTO datas){

        // verifica se os incrementos do açai são validos caso não retornar null
        FSAListDTO fsa = this.verifyFruitSweetAccompanimentsDatas(datas);
        if (fsa == null) return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Algum dos incrementos no açai é invaldo");


        // calcula o valor total do açai
        double totalPrice = this.calculateTotalPrice(datas);

        // salva o açai no banco de dados
        AcaiEntity acai = this.createAcai(fsa.accompaniment(),fsa.sweet(),fsa.fruit(),totalPrice,datas.acaiSize());
        this.acaiRepository.save(acai);

        return ResponseEntity.ok("Pedido da Açai Cadastrado com sucesso");
    }

    public ResponseEntity getAllMyAcai(){

        List<AcaiEntity> acais = acaiRepository.findByUser(authUser.get());

        if (acais.isEmpty()) return ResponseEntity.notFound().build();


        List<AcaiDatasToCostumerDTO> acaiRefactored = this.refactorAcais(acais);
        return  ResponseEntity.ok(acaiRefactored);

    }

    public ResponseEntity getMyEspecificAcai(UUID id){
        AcaiEntity acai = acaiRepository.findById(id).orElse(null);

        if(acai == null) return ResponseEntity.notFound().build();

        AcaiDatasToCostumerDTO acaiToCosutmer = new AcaiDatasToCostumerDTO(acai.getPrice(),acai.getSize(),this.reorganizeFruits(acai.getFruits()),this.reorganizeAccompaniment(acai.getAccompaniment()),this.reorganizeSweets(acai.getSweet()));

        return ResponseEntity.ok(acaiToCosutmer);

    }

    public ResponseEntity deleteMyAcaiOrder(UUID id){
        AcaiEntity acai = acaiRepository.findByIdAndUser(id, authUser.get());

        if (acai == null) return ResponseEntity.notFound().build();

        acaiRepository.delete(acai);

        return ResponseEntity.ok("Pedido deletado com suceso");


    }

    public ResponseEntity updateAcaiDatas(UUID id, AcaiDataDTO datas){

        AcaiEntity acai = acaiRepository.findById(id).orElse(null);
        if(acai == null)return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Açai não encontrado");


        FSAListDTO fsa = this.verifyFruitSweetAccompanimentsDatas(datas);
        if (fsa == null) return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Algum dos incrementos no açai é invaldo");

        // calcula o valor total do açai
        double totalPrice = this.calculateTotalPrice(datas);

        AcaiEntity acaiReorganized = this.reacreateAcaiEntity(acai,fsa.accompaniment(),fsa.sweet(),fsa.fruit(),totalPrice,datas.acaiSize());
        acaiRepository.save(acaiReorganized);
        return ResponseEntity.ok("Acai Atualizado");

    }

    public ResponseEntity getALl(){
        List<AcaiEntity> acais = this.acaiRepository.findAll();

        if (acais.isEmpty()) return ResponseEntity.notFound().build();

        List<AcaiDatasToCostumerDTO> acaiRefactored = this.refactorAcais(acais);
        return  ResponseEntity.ok(acaiRefactored);
    }



    // deixa o formato do retorno dos dados do acai mais legivel para o usuario
    private List<AcaiDatasToCostumerDTO> refactorAcais(List<AcaiEntity> acais){
        return acais.stream()
                .map(acai -> new AcaiDatasToCostumerDTO(
                                acai.getPrice(),
                                acai.getSize(),
                                this.reorganizeFruits(acai.getFruits()),// tranforma em uma formato mais legivel para o usuario
                                this.reorganizeAccompaniment(acai.getAccompaniment()),
                                this.reorganizeSweets(acai.getSweet())
                        )
                ).toList();
    }

    // verifica se as frutas, acompanhamentos e doces para o acai são validos FSA = Fruit, Sweet, Accompaniment
    private FSAListDTO verifyFruitSweetAccompanimentsDatas(AcaiDataDTO datas){

        List<AccompanimentEntity> accompaniments = accompanimentService.findManyByIds(datas.accompanimentIds());
        List<SweetEntity> sweets = sweetService.findManyById(datas.sweetsIds());
        List<FruitsEntity> fruits =  fruitsService.findManyByIds(datas.fruitsIds());
        if(accompaniments.isEmpty() || sweets.isEmpty() || fruits.isEmpty()) return null;

        return new FSAListDTO(accompaniments,fruits,sweets);

    }

    // logicas internas do sistema para calculo do preço do acai
    private double calculateTotalPrice(AcaiDataDTO datas){
        double totalPrice;
        if (datas.acaiSize() == AcaiSize.SMALL) totalPrice = 10;
        else if (datas.acaiSize() == AcaiSize.MEDIUM) totalPrice = 12;
        else totalPrice = 15;

        // acresenta o valor do açai para caso há mais de 1 de cada
        if (datas.accompanimentIds().size() > 1) totalPrice += (datas.accompanimentIds().size()*3)-3;

        if (datas.fruitsIds().size() > 1) totalPrice += (datas.fruitsIds().size()*3)-3;

        if (datas.sweetsIds().size() > 1) totalPrice += (datas.sweetsIds().size()*3)-3;

        return totalPrice;
    }

    // atualiza os dados do açai
    private AcaiEntity reacreateAcaiEntity(AcaiEntity acai, List<AccompanimentEntity> accompaniments, List<SweetEntity> sweets, List<FruitsEntity> fruits, double totalPrice, AcaiSize acaiSize){
        try {

            acai.getAccompaniment().addAll(accompaniments);
            acai.getSweet().addAll(sweets);
            acai.getFruits().addAll(fruits);

            acai.setSize(acaiSize);
            acai.setPrice(totalPrice);
            acai.setUser(authUser.get());

            return acai;

        }catch (ConcurrentModificationException exception){
            throw new ConcurrentModificationException("Erro encontrado função createAcai");
        }
    }

    private AcaiEntity createAcai(List<AccompanimentEntity> accompaniments, List<SweetEntity> sweets, List<FruitsEntity> fruits, double totalPrice, AcaiSize acaiSize){
       try {

           AcaiEntity acai = new AcaiEntity();

           acai.getAccompaniment().addAll(accompaniments);
           acai.getSweet().addAll(sweets);
           acai.getFruits().addAll(fruits);

           acai.setSize(acaiSize);
           acai.setPrice(totalPrice);
           acai.setUser(authUser.get());

           return acai;
       }catch (ConcurrentModificationException exception){
           throw new ConcurrentModificationException("Erro encontrado função createAcai");
       }
    }

    private Set<FSAFormatDTO> reorganizeFruits(Set<FruitsEntity> fruits){
        return fruits.stream()
                .map(fruit -> new FSAFormatDTO(fruit.getId(), fruit.getFruitName())).collect(Collectors.toSet());
    }
    private Set<FSAFormatDTO> reorganizeAccompaniment(Set<AccompanimentEntity> accompaniments){
        return accompaniments.stream()
                .map(accompaniment -> new FSAFormatDTO(accompaniment.getId(), accompaniment.getName())).collect(Collectors.toSet());
    }
    private Set<FSAFormatDTO> reorganizeSweets(Set<SweetEntity> sweets){
        return sweets.stream()
                .map(sweet -> new FSAFormatDTO( sweet.getId(), sweet.getName())).collect(Collectors.toSet());
    }

}
