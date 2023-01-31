package com.placar.resultado.service;

import com.placar.resultado.model.Placar;
import com.placar.resultado.repository.PlacarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;


@Service
public class PlacarService {

    @Autowired
    private PlacarRepository placarRepository;
    public void createPlacar(PlacarDao placarDao){
        Integer id = criaId();
        Placar placar = new Placar(id, placarDao.getValor1(), placarDao.getValor2());
        placarRepository.save(placar);
    }

    public Integer criaId(){
        Random ran = new Random();
        int x = ran.nextInt(100) + 2;
        return x;
    }

    public Placar getPlacarById(Integer id) {
        return placarRepository.findById(Long.valueOf(id)).get();
    }

    public void updatePlacar(Map<String, Object> placar, Integer id) {
        Placar placarUpdated = getPlacarById(id);
        placarUpdated.setValor1((Integer) placar.get("TimeA"));
        placarUpdated.setValor2((Integer) placar.get("TimeB"));
        placarRepository.save(placarUpdated);
        System.out.println("Placar atualizado");
    }
}
