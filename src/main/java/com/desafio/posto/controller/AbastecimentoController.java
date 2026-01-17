package com.desafio.posto.controller;

import com.desafio.posto.dtos.abastecimentoDto.AbastecimentoRequest;
import com.desafio.posto.dtos.abastecimentoDto.AbastecimentoResponse;
import com.desafio.posto.services.AbastecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abastecimento")
public class AbastecimentoController {

    private final AbastecimentoService abastecimentoService;

    @PostMapping
    public ResponseEntity<Void> abastecer (@RequestBody AbastecimentoRequest request) {
        abastecimentoService.novoAbastecimento(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<AbastecimentoResponse>> buscarHistorico () {
        List<AbastecimentoResponse> historico = abastecimentoService.listarAbastecimentos();
        return ResponseEntity.ok(historico);
    }


}
