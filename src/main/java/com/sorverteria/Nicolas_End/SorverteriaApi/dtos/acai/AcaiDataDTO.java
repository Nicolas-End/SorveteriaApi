package com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai;

import com.sorverteria.Nicolas_End.SorverteriaApi.enums.AcaiSize;
import java.util.List;
import java.util.UUID;

public record AcaiDataDTO(List<UUID> fruitsIds, List<UUID> sweetsIds, List<UUID> accompanimentIds, AcaiSize acaiSize) {
}
