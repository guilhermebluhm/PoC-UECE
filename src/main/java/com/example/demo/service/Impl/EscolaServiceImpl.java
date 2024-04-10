package com.example.demo.service.Impl;

import com.example.demo.model.Escola;
import com.example.demo.model.Sala;
import com.example.demo.repository.EscolaRepository;
import com.example.demo.repository.SalaRepository;
import com.example.demo.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EscolaServiceImpl implements EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public Escola saveModel(Escola escola) {
        return this.escolaRepository.save(escola);
    }

    @Override
    public List<Escola> findAll() {
        if(this.escolaRepository.findAll().isEmpty())
            return new ArrayList<>();
        else
            return this.escolaRepository.findAll();
    }

    @Override
    public Escola findById(String id) {
        return this.escolaRepository.findById(Long.valueOf(id)).orElseThrow(RuntimeException::new);
    }

    @Override
    public Escola updateModel(String id, String nomeEscola) {
        Escola escola = this.findById(id);
        if(escola != null) {
            escola.setNomeEscola(nomeEscola);
            return this.escolaRepository.save(escola);
        }
        throw new RuntimeException("erro geral da aplicacao - erro generico");
    }

    @Override
    public void deleteModel(String id) {
        this.escolaRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public Escola addSalaEscola(String idEscola, String idSala) {
        Escola escola = this.findById(idEscola);
        if(this.salaRepository.findById(Long.valueOf(idSala)).isPresent()){
            Sala sala = this.salaRepository.findById(Long.valueOf(idSala)).get();
            escola.setListaSala(sala);
            this.escolaRepository.save(escola);
        }
        else{
            throw new RuntimeException("erro geral da aplicacao - descricao generica");
        }
        return escola;
    }


}
