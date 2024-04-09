package com.example.demo.service.Impl;

import com.example.demo.model.Sala;
import com.example.demo.repository.SalaRepository;
import com.example.demo.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;

public class SalaServiceImpl implements SalaService {

    @Autowired
    private SalaRepository sl;

    @Override
    public Sala adicionarSala(Sala sala) {
        return this.sl.save(sala);
    }

    @Override
    public void removerSala(String idSala) {
        this.sl.deleteById(Long.valueOf(idSala));
    }
}
