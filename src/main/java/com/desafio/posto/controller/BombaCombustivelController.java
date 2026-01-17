package com.desafio.posto.controller;

import com.desafio.posto.dtos.bombaCombustivelDto.BombaCombustivelRequest;
import com.desafio.posto.dtos.bombaCombustivelDto.BombaCombustivelResponse;
import com.desafio.posto.services.BombaCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bombaCombustivel")
public class BombaCombustivelController {

    private final BombaCombustivelService bombaCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criarBomba (BombaCombustivelRequest request) {

        bombaCombustivelService.novaBomba(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BombaCombustivelResponse>> listarBombas () {
        List<BombaCombustivelResponse> bombas = bombaCombustivelService.listarBombas();
        return ResponseEntity.ok(bombas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombaCombustivelResponse> buscarBombaPorId (UUID idBomba) {
        bombaCombustivelService.buscarBombaPorId(idBomba);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarBomba (UUID idBomba, BombaCombustivelRequest request) {
        bombaCombustivelService.alterarBomba(idBomba, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBomba (@PathVariable UUID idBomba) {
        bombaCombustivelService.deletarBomba(idBomba);
        return ResponseEntity.ok().build();
    }
}
