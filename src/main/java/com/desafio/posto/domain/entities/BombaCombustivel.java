package com.desafio.posto.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "bombas_combustivel")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BombaCombustivel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nomeBomba;
    @ManyToOne
    @JoinColumn(name = "combustivel_id")
    private TipoCombustivel tipoCombustivel;
}
