package com.examenspring.repository;

import com.examenspring.model.Pasajero;
import com.examenspring.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PilotoRepository extends JpaRepository<Piloto, Integer> {
    Optional<Piloto> findByNombre(String nombre);
}
