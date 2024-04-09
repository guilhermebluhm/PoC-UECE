package com.example.demo.service.Impl;

import com.example.demo.model.Escola;
import com.example.demo.model.Sala;
import com.example.demo.repository.EscolaRepository;
import com.example.demo.repository.SalaRepository;
import com.example.demo.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
    public void adicionarSalaEscola(String idSala, String idEscola) {
        Optional<Escola> byId1 = this.esc.findById(Long.valueOf(idSala));
        Sala byId = this.sl.findById(Long.valueOf(idSala)).get();

        if(byId1.isPresent()){
            byId.addSalaEscola(byId1.get());
            this.sl.save(byId);
        }

    }

    @Override
    public List<Sala> todasSalas() {
        return this.sl.findAll();
    }
}
