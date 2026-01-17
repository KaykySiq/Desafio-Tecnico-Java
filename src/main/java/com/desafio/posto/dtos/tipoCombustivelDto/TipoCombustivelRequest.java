package com.desafio.posto.dtos.tipoCombustivelDto;

import java.math.BigDecimal;

public record TipoCombustivelRequest(
        String nome,
        BigDecimal precoLitro
) {}
