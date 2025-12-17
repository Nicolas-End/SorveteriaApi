package com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai;

import com.sorverteria.Nicolas_End.SorverteriaApi.enums.AcaiSize;

public record AcaiDatasToCostumerDTO(double total_price, AcaiSize size, java.util.Set<com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits.FruitsEntity> fruits, java.util.Set<com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment.AccompanimentEntity> accompaniment, java.util.Set<com.sorverteria.Nicolas_End.SorverteriaApi.domains.sweet.SweetEntity> sweet) {
}
