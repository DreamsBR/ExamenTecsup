package com.examenspring.controller;


import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Aerolinea;
import com.examenspring.model.Pasajero;
import com.examenspring.service.AreolineaService;
import com.examenspring.service.PasajeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/v1/pasajero")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    @PostMapping(value = "/save")
    public ResponseBase save(@RequestBody Pasajero pasajero){
        return pasajeroService.savePasajero(pasajero);
    }

    @GetMapping(value = "get/{id}")
    public ResponseBase findById(@PathVariable("id") Integer id){
        return pasajeroService.findById(id);
    }
}
