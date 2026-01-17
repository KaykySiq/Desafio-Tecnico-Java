package com.desafio.posto.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "abastecimentos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "bomba_id")
    private BombaCombustivel bombaCombustivel;
    private LocalDate dataAbastecimento;
    private BigDecimal total;
    private Float litros;
}
