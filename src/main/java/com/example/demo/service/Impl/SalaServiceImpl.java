package com.example.demo.service.Impl;

import com.example.demo.model.Escola;
import com.example.demo.model.Sala;
import com.example.demo.repository.EscolaRepository;
import com.example.demo.repository.SalaRepository;
import com.example.demo.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SalaServiceImpl implements SalaService {

    @Autowired
    private SalaRepository sl;

    @Autowired
    private EscolaRepository esc;

    @Override
    public Sala adicionarSala(Sala sala) {
        return this.sl.save(sala);
    }

    @Override
    public void removerSala(String idSala) {
        this.sl.deleteById(Long.valueOf(idSala));
    }

    @Override
    public List<Sala> todasSalas() {
        return this.sl.findAll();
    }
}
