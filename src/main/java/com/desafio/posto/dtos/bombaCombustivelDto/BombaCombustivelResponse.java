package com.desafio.posto.dtos.bombaCombustivelDto;

import com.desafio.posto.domain.entities.TipoCombustivel;

import java.util.UUID;

public record BombaCombustivelResponse(
        UUID id,
        String nome,
        TipoCombustivel combustivel
) {}
