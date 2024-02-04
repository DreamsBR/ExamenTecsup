package com.examenspring.controller;

import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Piloto;
import com.examenspring.service.PilotoService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("api/v1/piloto")
@RestController
public class PilotoController {

    private final PilotoService pilotoService;

    @GetMapping("/")
    public ResponseBase getAllPilotos() {
        return pilotoService.getAll();
    }

    @PostMapping("/save")
    public ResponseBase save(@RequestBody Piloto piloto) {
        return pilotoService.save(piloto);
    }

    @GetMapping("/get/{id}")
    public ResponseBase getById(@PathVariable("id") Integer id){
        return pilotoService.findBy(id);
    }

    @PostMapping("/{pilotoId}/pilotovuelo/{vueloId}")
    public ResponseBase savePilotoVuelo(@PathVariable("pilotoId") Integer pilotoId, @PathVariable("vueloId") Integer vueloId){
        return pilotoService.savePilotoVuelo(pilotoId, vueloId);
    }
}
