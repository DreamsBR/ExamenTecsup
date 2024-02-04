package com.examenspring.controller;


import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Aerolinea;
import com.examenspring.service.AreolineaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/v1/areolinea")
public class AreolineaController {

    private final AreolineaService areolineaService;

    @PostMapping(value = "/save")
    public ResponseBase save(@RequestBody Aerolinea areolinea){
        return areolineaService.saveAreolinea(areolinea);
    }

    @GetMapping(value = "get/{id}")
    public ResponseBase findById(@PathVariable("id") Integer id){
        return areolineaService.findById(id);
    }
}
