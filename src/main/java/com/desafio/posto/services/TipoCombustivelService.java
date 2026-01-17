package com.desafio.posto.services;

import com.desafio.posto.domain.entities.TipoCombustivel;
import com.desafio.posto.domain.repositories.TipoCombustivelRepository;
import com.desafio.posto.dtos.tipoCombustivelDto.TipoCombustivelRequest;
import com.desafio.posto.dtos.tipoCombustivelDto.TipoCombustivelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TipoCombustivelService {
    private final TipoCombustivelRepository tipoCombustivelRepo;

    public void novoCombustivel(TipoCombustivelRequest tipoCombustivelRequest) {

        TipoCombustivel combustivel = new TipoCombustivel();
        combustivel.setNome(tipoCombustivelRequest.nome());
        combustivel.setPrecoLitro(tipoCombustivelRequest.precoLitro());

        tipoCombustivelRepo.save(combustivel);
    }

    public List<TipoCombustivelResponse> listarCombustivel() {
        List<TipoCombustivel> combustivel = tipoCombustivelRepo.findAll();

         return combustivel.stream()
                .map(
                combustiveis -> new TipoCombustivelResponse(
                        combustiveis.getId(),
                        combustiveis.getNome(),
                        combustiveis.getPrecoLitro())
                ).toList();
    }

    public void alterarCombustivel (UUID id, TipoCombustivelRequest tipoCombustivelRequest) {
        var combustivelEntity = this.tipoCombustivelRepo.findById(id);

        var combustivel = combustivelEntity.get();
        combustivel.setNome(tipoCombustivelRequest.nome());
        combustivel.setPrecoLitro(tipoCombustivelRequest.precoLitro());

        tipoCombustivelRepo.save(combustivel);
    }

    public void deletarCombustivel (UUID id) {
        tipoCombustivelRepo.deleteById(id);
    }
}
