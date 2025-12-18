package com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai;

import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.FruitSweetAccomp.FSAFormatDTO;

import com.sorverteria.Nicolas_End.SorverteriaApi.enums.AcaiSize;

import java.util.Set;

public record AcaiDatasToCostumerDTO(double total_price, AcaiSize size, Set<FSAFormatDTO> fruits, Set<FSAFormatDTO> accompaniments,Set<FSAFormatDTO> sweets) {
}
