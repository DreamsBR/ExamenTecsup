package com.examenspring.controller;


import com.examenspring.configuration.Response.ResponseBase;
import com.examenspring.model.Avion;
import com.examenspring.service.AvionService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/v1/avion")
public class AvionController {

    private final AvionService avionService;

    @PostMapping(value = "/save")
    public ResponseBase save(@RequestBody Avion avion){
        return avionService.saveAvion(avion);
    }

    @GetMapping(value = "get/{serie}")
    public ResponseBase findById(@PathVariable("serie") String serie){
        return avionService.findBySerie(serie);
    }
}
