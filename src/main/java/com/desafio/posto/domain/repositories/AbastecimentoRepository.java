package com.desafio.posto.domain.repositories;

import com.desafio.posto.domain.entities.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, UUID> {}
