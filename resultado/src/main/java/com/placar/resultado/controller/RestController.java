package com.placar.resultado.controller;

import com.placar.resultado.model.Placar;
import com.placar.resultado.repository.PlacarRepository;
import com.placar.resultado.service.PlacarDao;
import com.placar.resultado.service.PlacarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("placar")
public class RestController {
    @Autowired
    private PlacarService placarService;

    @PostMapping
    public ResponseEntity createPlacar(@RequestBody Map<String, Integer> json){
        Integer timeA = json.get("TimeA");
        Integer timeB = json.get("TimeB");
        PlacarDao placarDao = new PlacarDao(timeA, timeB);
        placarService.createPlacar(placarDao);
        return ResponseEntity.ok("Placar registrado com sucesso");
    }

    @GetMapping("/{id}")
    public Placar getPlacar(@PathVariable Integer id){
        Placar placar = placarService.getPlacarById(id);
        return placar;
    }

    @GetMapping
    public String funcionando(){
        return "Teste controller fucionando";
    }
}
