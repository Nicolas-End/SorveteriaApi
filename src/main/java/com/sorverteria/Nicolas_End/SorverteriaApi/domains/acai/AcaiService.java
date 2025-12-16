package com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment.AccompanimentEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment.AccompanimentService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits.FruitsEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits.FruitsService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet.SweetEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet.SweetService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.AcaiDataDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.enums.AcaiSize;
import com.sorverteria.Nicolas_End.SorverteriaApi.infra.security.AuthenticatedUser;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcaiService {
    private final AcaiRepository acaiRepository;
    private final AccompanimentService accompanimentService;
    private final SweetService sweetService;
    private final FruitsService fruitsService;
    private final AuthenticatedUser authUser;
    public AcaiService(AcaiRepository acaiRepository, AccompanimentService accompanimentService, SweetService sweetService, FruitsService fruitsService, AuthenticatedUser authUser){
        this.acaiRepository = acaiRepository;
        this.accompanimentService = accompanimentService;
        this.sweetService = sweetService;
        this.fruitsService = fruitsService;
        this.authUser = authUser;
    }

    @Transactional
    public ResponseEntity addNewAcai(AcaiDataDTO datas){

        // verifica se algum item é invalido
        List<AccompanimentEntity> accompaniments = accompanimentService.findManyByIds(datas.accompanimentIds());
        List<SweetEntity> sweets = sweetService.findManyById(datas.sweetsIds());
        List<FruitsEntity> fruits =  fruitsService.findManyByIds(datas.fruitsIds());
        if(accompaniments.isEmpty() || sweets.isEmpty() || fruits.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Acompanhamentos, frutas ou doces Invalidos");

        // calcula o valor total do açai
        double totalPrice = this.calculateTotalPrice(datas);

        // salva o açai no banco de dados
        AcaiEntity acai = this.createAcai(accompaniments,sweets,fruits,totalPrice,datas.acaiSize());
        this.acaiRepository.save(acai);

        return ResponseEntity.ok("Pedido da Açai Cadastrado com sucesso");
    }

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

    private AcaiEntity createAcai(List<AccompanimentEntity> accompaniments, List<SweetEntity> sweets, List<FruitsEntity> fruits, double totalPrice, AcaiSize acaiSize){
        AcaiEntity acai = new AcaiEntity();

        accompaniments.forEach(accompaniment -> acai.getAccompaniment().add(accompaniment));

        sweets.forEach(sweet -> acai.getSweet().add(sweet));

        fruits.forEach(fruit -> acai.getFruits().add(fruit));

        acai.setSize(acaiSize);
        acai.setPrice(totalPrice);
        acai.setUser(authUser.get());

        return acai;
    }

}
