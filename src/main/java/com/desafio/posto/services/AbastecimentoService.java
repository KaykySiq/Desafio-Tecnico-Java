package com.desafio.posto.services;

import com.desafio.posto.domain.entities.Abastecimento;
import com.desafio.posto.domain.entities.BombaCombustivel;
import com.desafio.posto.domain.repositories.AbastecimentoRepository;
import com.desafio.posto.domain.repositories.BombaCombustivelRepository;
import com.desafio.posto.dtos.abastecimentoDto.AbastecimentoRequest;
import com.desafio.posto.dtos.abastecimentoDto.AbastecimentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {
    private final AbastecimentoRepository abastecimentoRepo;
    private final BombaCombustivelService bombaCombustivelService;
    private final BombaCombustivelRepository bombaCombustivelRepo;

    public void novoAbastecimento (AbastecimentoRequest abastecimentoRequest) {
        BombaCombustivel bomba = bombaCombustivelService.buscarBombaPorId(abastecimentoRequest.bombaId());
        BigDecimal valorTotal = bomba.getTipoCombustivel().getPrecoLitro().multiply(BigDecimal.valueOf(abastecimentoRequest.litros()));

        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setDataAbastecimento(LocalDate.now());
        abastecimento.setBombaCombustivel(bomba);
        abastecimento.setLitros(abastecimentoRequest.litros());
        abastecimento.setTotal(valorTotal);

        abastecimentoRepo.save(abastecimento);
    }

    public List<AbastecimentoResponse> listarAbastecimentos () {
        List<Abastecimento> abastecimento = this.abastecimentoRepo.findAll();

        return abastecimento.stream()
                .map( abastecimentos -> new AbastecimentoResponse(
                        abastecimentos.getId(),
                        abastecimentos.getBombaCombustivel(),
                        abastecimentos.getDataAbastecimento(),
                        abastecimentos.getTotal(),
                        abastecimentos.getLitros())
                ).toList();
    }

    public void alterarAbastecimento (UUID id, AbastecimentoRequest abastecimentoRequest) {
        var abastecimentoEntity = this.abastecimentoRepo.findById(id);

        var abastecimento = abastecimentoEntity.get();
        BombaCombustivel bomba = bombaCombustivelRepo.getReferenceById(abastecimentoRequest.bombaId());
        abastecimento.setBombaCombustivel(bomba);
        abastecimento.setLitros(abastecimentoRequest.litros());

        abastecimentoRepo.save(abastecimento);
    }

    public void deletarAbastecimento (UUID id) {
        abastecimentoRepo.deleteById(id);
    }

}
