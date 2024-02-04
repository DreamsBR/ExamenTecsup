package com.examenspring.service;

import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Aerolinea;
import com.examenspring.repository.AreolineaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AreolineaService {

    private final AreolineaRepository areolineaRepository;

    public ResponseBase saveAreolinea(Aerolinea areolinea){

        Optional<Aerolinea> areolineaOptional = areolineaRepository.findByNombre(areolinea.getNombre());
        if(areolineaOptional.isPresent()){
            return new ResponseBase(
                    400,
                    "Areolinea ya existe",
                    false,
                    Optional.empty()
            );
        }
        areolineaRepository.save(areolinea);
        return new ResponseBase(200, "Areolinea guardada", true, Optional.of(areolinea));
    }

    public ResponseBase findById(Integer id){

        Optional<Aerolinea> areolineaOptional = areolineaRepository.findById(id);
        if(areolineaOptional.isPresent()){
            return new ResponseBase(
                    200,
                    "Area encontrada",
                    true,
                    Optional.of(areolineaOptional.get())
            );
        }
        return new ResponseBase(
                400,
                "Area no encontrada",
                false,
                Optional.empty()
        );
    }
}
