package com.desafio.posto.dtos.abastecimentoDto;


import java.util.UUID;

public record AbastecimentoRequest(
        UUID bombaId,
        Float litros
) {}
