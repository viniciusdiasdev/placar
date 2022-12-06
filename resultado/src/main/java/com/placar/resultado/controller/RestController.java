package com.placar.resultado.controller;

import com.placar.resultado.model.Placar;
import com.placar.resultado.service.PlacarDao;
import com.placar.resultado.service.PlacarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("placar")
public class    RestController {
    @Autowired
    private PlacarService placarService;

    @PostMapping
    public ResponseEntity<PlacarDao> createPlacar(@RequestBody Map<String, Integer> json){
        Integer timeA = json.get("TimeA");
        Integer timeB = json.get("TimeB");
        PlacarDao placarDao = new PlacarDao(timeA, timeB);
        placarService.createPlacar(placarDao);
        return new ResponseEntity<>(placarDao, HttpStatus.OK);
    }

    @PostMapping("/notfound")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void notFound(@RequestBody Map<String, Integer> json){
    }

    @PostMapping("/badrequest")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void badRequest(@RequestBody Map<String, Integer> json){
    }

    @PostMapping("/badgateway")
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public void badGateway(@RequestBody Map<String, Integer> json){
    }

    @PostMapping("/internal")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void internalError(@RequestBody Map<String, Integer> json){
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
