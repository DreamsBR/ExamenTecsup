package com.examenspring.controller;

import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Vuelo;
import com.examenspring.service.VueloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/vuelo")
public class VueloController {

    private final VueloService vueloService;

    @PostMapping(value = "/save")
    public ResponseBase saveVuelo(@RequestBody Vuelo vuelo){
        return vueloService.saveVuelo(vuelo);
    }

    @GetMapping(value = "get/{id}")
    public ResponseBase saveVuelo(@PathVariable("id") Integer id){
        return vueloService.findById(id);
    }

    @GetMapping
    public ResponseBase getAllVuelos(){
        return vueloService.findAll();
    }
}
