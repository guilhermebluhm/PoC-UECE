package com.example.demo.service.Impl;

import com.example.demo.model.Sala;
import com.example.demo.repository.SalaRepository;
import com.example.demo.service.SalaService;
import com.example.demo.utils.misc.ClearningData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalaServiceImpl implements SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public Sala addSala(Sala sala) {

        ClearningData data = new ClearningData();
        return this.salaRepository.save(sala);

    }

    @Override
    public void removeSala(String idSala) {
        this.salaRepository.deleteById(Long.valueOf(idSala));
    }

    @Override
    public List<Sala> allSalas() {
        return this.salaRepository.findAll();
    }
}
