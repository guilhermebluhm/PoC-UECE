package com.example.demo.service.Impl;

import com.example.demo.model.Endereco;
import com.example.demo.model.Escola;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.repository.EscolaRepository;
import com.example.demo.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EscolaServiceImpl implements EscolaService {

    @Autowired
    private EscolaRepository esc;

    @Autowired
    private EnderecoRepository end;

    @Override
    public Escola saveModel(Escola escola) {
        return this.esc.save(escola);
    }

    @Override
    public List<Escola> findAll() {
        if(this.esc.findAll().isEmpty())
            return new ArrayList<>();
        else
            return this.esc.findAll();
    }

    @Override
    public Escola findById(String id) {
        return this.esc.findById(Long.valueOf(id)).orElseThrow(RuntimeException::new);
    }

    @Override
    public void updateModel(String id, String nomeEscola) {
        Escola byId = this.findById(id);
        byId.setNomeEscola(nomeEscola);
        this.esc.save(byId);
    }

    @Override
    public void deleteModel(String id) {
        this.esc.deleteById(Long.valueOf(id));
    }

    @Override
    public Escola adicionarSalaEscola(String idEscola, String idSala) {
        return null;
    }


}
