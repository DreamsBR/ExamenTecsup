package com.examenspring.repository;

import com.examenspring.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvionRepository  extends JpaRepository<Avion, Integer> {

    Optional<Avion> findBySerie(String serie);


}
