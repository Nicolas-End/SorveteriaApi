package com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.FruitSweetAccomp;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment.AccompanimentEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits.FruitsEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet.SweetEntity;

import java.util.List;

public record FSAListDTO(List<AccompanimentEntity> accompaniment, List<FruitsEntity> fruit, List<SweetEntity> sweet){
}
