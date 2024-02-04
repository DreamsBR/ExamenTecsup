package com.examenspring.service;

import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Pasajero;
import com.examenspring.repository.PasajeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    public ResponseBase savePasajero(Pasajero pasajero){
        Optional<Pasajero> pasajeroOptional = pasajeroRepository.findByNombre(pasajero.getNombre());

        if(pasajeroOptional.isPresent()){
            return new ResponseBase(400, "El pasajero ya existe", false, Optional.empty());
        }
        pasajeroRepository.save(pasajero);
        return new ResponseBase(200, "Pasajero creado exitosamente", true, Optional.of(pasajero));
    }

    public ResponseBase findById(Integer id){
        Optional<Pasajero> pasajeroOptional = pasajeroRepository.findById(id);
        if(pasajeroOptional.isPresent()){
            return new ResponseBase(200, "Pasajero encontrado exitosamente", true, Optional.of(pasajeroOptional.get()));
        }
        return new ResponseBase(400, "Pasajero no encontrado", false, Optional.empty());
    }
}
