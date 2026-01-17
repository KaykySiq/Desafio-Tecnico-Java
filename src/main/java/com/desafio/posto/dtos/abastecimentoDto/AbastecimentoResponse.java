package com.desafio.posto.dtos.abastecimentoDto;

import com.desafio.posto.domain.entities.BombaCombustivel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record AbastecimentoResponse(
        UUID id,
        BombaCombustivel bomba,
        LocalDate dataAbastecimento,
        BigDecimal total,
        Float litros
) {}
