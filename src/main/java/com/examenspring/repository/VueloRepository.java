package com.examenspring.repository;

import com.examenspring.model.Pasajero;
import com.examenspring.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {

    //Optional<Vuelo> findByVueloId(Integer id);

}
