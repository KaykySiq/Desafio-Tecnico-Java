package com.desafio.posto.domain.repositories;

import com.desafio.posto.domain.entities.TipoCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoCombustivelRepository extends JpaRepository<TipoCombustivel, UUID> {}
