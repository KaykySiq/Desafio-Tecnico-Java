package com.desafio.posto.dtos.bombaCombustivelDto;


import java.util.UUID;

public record BombaCombustivelRequest(
        String nome,
        UUID combustivelId
) {}
