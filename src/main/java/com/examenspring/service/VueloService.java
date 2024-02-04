package com.examenspring.service;

import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Vuelo;
import com.examenspring.repository.VueloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VueloService {

    private final VueloRepository vueloRepository;

    @Transactional
    public ResponseBase saveVuelo(Vuelo vuelo){

        vueloRepository.save(vuelo);
        return new ResponseBase(200, "Vuelo creado exitosamente", true, Optional.of(vuelo));
    }

    public ResponseBase findById(Integer id){
        Optional<Vuelo> vueloOptional = vueloRepository.findById(id);
        if(vueloOptional.isPresent()){
            return new ResponseBase(200, "Vuelo encontrado exitosamente", true, Optional.of(vueloOptional.get()));
        }
        return new ResponseBase(400, "Vuelo no encontrado", false, Optional.empty());
    }

    public ResponseBase findAll(){
        return new ResponseBase(200, "Vuelos encontrados exitosamente", true, Optional.of(vueloRepository.findAll()));
    }
}
