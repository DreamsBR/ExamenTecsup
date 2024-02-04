package com.examenspring.service;


import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Avion;
import com.examenspring.repository.AvionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AvionService {

    private final AvionRepository avionRepository;

    @Transactional
    public ResponseBase saveAvion(Avion avion){
        Optional<Avion> areolineaOptional = avionRepository.findBySerie(avion.getSerie());
        if(areolineaOptional.isPresent()){
            return new ResponseBase(
                    400,
                    "Areolinea ya existe",
                    false,
                    Optional.empty()
            );
        }
        avionRepository.save(avion);
        return new ResponseBase(200, "Areolinea guardada", true, Optional.of(avion));

    }

    public ResponseBase findBySerie(String serie){

        Optional<Avion> areolineaOptional = avionRepository.findBySerie(serie);
        if(areolineaOptional.isPresent()){
            return new ResponseBase(
                    200,
                    "Avion encontrado",
                    true,
                    Optional.of(areolineaOptional.get())
            );
        }
        return new ResponseBase(
                400,
                "Avion no encontrado",
                false,
                Optional.empty()
        );
    }

}
