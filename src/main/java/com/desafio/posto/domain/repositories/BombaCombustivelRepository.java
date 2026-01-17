package com.desafio.posto.domain.repositories;

import com.desafio.posto.domain.entities.BombaCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BombaCombustivelRepository extends JpaRepository<BombaCombustivel, UUID> {}
