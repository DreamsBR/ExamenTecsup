package com.examenspring.repository;

import com.examenspring.model.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreolineaRepository extends JpaRepository<Aerolinea, Integer> {

    Optional<Aerolinea> findByNombre(String nombre);
}
