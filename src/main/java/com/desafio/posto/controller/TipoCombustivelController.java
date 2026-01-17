package com.desafio.posto.controller;

import com.desafio.posto.dtos.tipoCombustivelDto.TipoCombustivelRequest;
import com.desafio.posto.dtos.tipoCombustivelDto.TipoCombustivelResponse;
import com.desafio.posto.services.TipoCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tiposCombustivel")
public class TipoCombustivelController {
    private final TipoCombustivelService tipoCombustivelService;

    @PostMapping
    public ResponseEntity<Void> novoCombustivel (@RequestBody TipoCombustivelRequest request) {
        tipoCombustivelService.novoCombustivel(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<TipoCombustivelResponse>> buscarCombustiveis () {
        List<TipoCombustivelResponse> combustiveis = tipoCombustivelService.listarCombustivel();
        return ResponseEntity.ok(combustiveis);
    }

    @PutMapping()
    public ResponseEntity<Void> alterarCombustivel (@RequestBody TipoCombustivelRequest request, UUID combustivelId) {
        tipoCombustivelService.alterarCombustivel(combustivelId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping({"/id"})
    public ResponseEntity<Void> deletarCombustivel (UUID combustivelId) {
        tipoCombustivelService.deletarCombustivel(combustivelId);
        return ResponseEntity.ok().build();
    }
}
