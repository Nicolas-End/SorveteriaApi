package com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai;

import com.sorverteria.Nicolas_End.SorverteriaApi.enums.AcaiSize;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record AcaiDataDTO(ArrayList<UUID> fruitsIds, ArrayList<UUID> sweetsIds, ArrayList<UUID> accompanimentIds, AcaiSize acaiSize) {
}
