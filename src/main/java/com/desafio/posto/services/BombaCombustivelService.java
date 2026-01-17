package com.desafio.posto.services;

import com.desafio.posto.domain.entities.BombaCombustivel;
import com.desafio.posto.domain.entities.TipoCombustivel;
import com.desafio.posto.domain.repositories.BombaCombustivelRepository;
import com.desafio.posto.domain.repositories.TipoCombustivelRepository;
import com.desafio.posto.dtos.bombaCombustivelDto.BombaCombustivelRequest;
import com.desafio.posto.dtos.bombaCombustivelDto.BombaCombustivelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BombaCombustivelService {
    private final BombaCombustivelRepository bombaCombustivelRepo;
    private final TipoCombustivelRepository tipoCombustivelRepo;

    public void novaBomba (BombaCombustivelRequest bombaCombustivelRequest) {

        BombaCombustivel bomba = new BombaCombustivel();
        bomba.setNomeBomba(bombaCombustivelRequest.nome());
        TipoCombustivel combustivel = tipoCombustivelRepo.getReferenceById(bombaCombustivelRequest.combustivelId());
        bomba.setTipoCombustivel(combustivel);
        bombaCombustivelRepo.save(bomba);
    }

    public List<BombaCombustivelResponse> listarBombas() {
        List<BombaCombustivel> bomba = this.bombaCombustivelRepo.findAll();

        return bomba.stream()
                .map( bombas -> new BombaCombustivelResponse(
                        bombas.getId(),
                        bombas.getNomeBomba(),
                        bombas.getTipoCombustivel())
                ).toList();
    }

    public BombaCombustivel buscarBombaPorId (UUID id) {
        return bombaCombustivelRepo.findById(id).orElseThrow(() -> new NullPointerException("Bomba não encontrada."));
    }

    public void alterarBomba (UUID id, BombaCombustivelRequest bombaCombustivelRequest) {
        var bombaEntity = this.bombaCombustivelRepo.findById(id);

        var bomba = bombaEntity.get();
        bomba.setNomeBomba(bombaCombustivelRequest.nome());
        TipoCombustivel combustivel = tipoCombustivelRepo.getReferenceById(bombaCombustivelRequest.combustivelId());
        bomba.setTipoCombustivel(combustivel);

        bombaCombustivelRepo.save(bomba);
    }

    public void deletarBomba (UUID id) {
        bombaCombustivelRepo.deleteById(id);
    }
}
