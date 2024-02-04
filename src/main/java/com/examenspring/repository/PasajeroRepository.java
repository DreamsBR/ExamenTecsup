package com.examenspring.repository;

import com.examenspring.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasajeroRepository  extends JpaRepository<Pasajero, Integer> {

    Optional<Pasajero> findByNombre(String nombre);
}
