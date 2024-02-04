package com.examenspring.service;

import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Reserva;
import com.examenspring.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ResponseBase saveReserva (Reserva reserva){
        /*
        Optional<Reserva> reservaOp = reservaRepository.findById(reserva.getReservaId());
        if (reservaOp.isPresent()){
            return new ResponseBase(400, "Reserva ya existente", false, Optional.empty());
        }
        */

        reservaRepository.save(reserva);
        return new ResponseBase(200, "Reserva guardada con exito", true, Optional.of(reserva));
    }

    public ResponseBase findById (Integer id){
        Optional<Reserva> reservaOp = reservaRepository.findById(id);
        if (reservaOp.isPresent()){
            return new ResponseBase(200, "Reserva encontrada", true, Optional.of(reservaOp.get()));
        }
        return new ResponseBase(400, "Reserva no encontrada", false, Optional.empty());
    }

    public ResponseBase findAll(){
        List<Reserva> reservas = reservaRepository.findAll();
        return new ResponseBase(200, "Reservas encontradas", true, Optional.of(reservas));
    }
}
