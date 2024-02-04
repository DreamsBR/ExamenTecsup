package com.examenspring.service;

import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Piloto;
import com.examenspring.model.Vuelo;
import com.examenspring.repository.PilotoRepository;
import com.examenspring.repository.VueloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PilotoService {

    private final PilotoRepository pilotoRepository;

    private final VueloRepository vueloRepository;

    public ResponseBase save(Piloto piloto){
        Optional<Piloto> pilotoOptonal = pilotoRepository.findByNombre(piloto.getNombre());
        if(pilotoOptonal.isPresent()){
            return new ResponseBase(400, "Piloto Ya existe", false, Optional.empty());
        }
        pilotoRepository.save(piloto);
        return new ResponseBase(200, "Piloto Creado", true, Optional.of(piloto));
    }

    public ResponseBase findBy(Integer id){
        Optional<Piloto> piloto = pilotoRepository.findById(id);
        if(piloto.isPresent()){
            return new ResponseBase(200, "Piloto Encontrado", true, Optional.of(piloto.get()));
        }
        return new ResponseBase(400, "Piloto No Encontrado", false, Optional.empty());
    }

    public ResponseBase getAll(){
        if(pilotoRepository.findAll().isEmpty()){
            return new ResponseBase(400, "Pilotos No Encontrados", false, Optional.empty());
        }
        return new ResponseBase(200, "Pilotos Encontrados", true, Optional.of(pilotoRepository.findAll()));
    }

    public ResponseBase savePilotoVuelo(Integer pilotoId, Integer vueloId) {

        List<Vuelo> vuelos = null;

        Piloto piloto = pilotoRepository.findById(pilotoId).get();
        Vuelo vuelo = vueloRepository.findById(vueloId).get();

        vuelos = piloto.getVuelos();
        vuelos.add(vuelo);

        piloto.setVuelos(vuelos);

        pilotoRepository.save(piloto);;
        return  new ResponseBase(200, "Piloto Agregado", true, Optional.of(piloto));

    }
}
