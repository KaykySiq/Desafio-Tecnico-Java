package com.desafio.posto.dtos.tipoCombustivelDto;

import java.math.BigDecimal;
import java.util.UUID;

public record TipoCombustivelResponse(
        UUID id,
        String nome,
        BigDecimal precoLitro
) {}
