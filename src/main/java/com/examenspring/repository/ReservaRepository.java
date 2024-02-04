package com.examenspring.repository;

import com.examenspring.model.Pasajero;
import com.examenspring.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
