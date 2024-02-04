package com.examenspring.controller;

import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Reserva;
import com.examenspring.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/reserva")
public class ReservaController {

    private final ReservaService reservaService;;

   @GetMapping("/")
    public ResponseBase getReservas(){
        return reservaService.findAll();
    }

   @PostMapping("/save")
    public ResponseBase saveReservas(@RequestBody Reserva reserva){
        return reservaService.saveReserva(reserva);
    }

    @GetMapping("/{id}")
    public ResponseBase getReservas(@PathVariable("id") Integer id){
        return reservaService.findById(id);
    }
}
