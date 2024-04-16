package com.example.demo.service.Impl;

import com.example.demo.model.Escola;
import com.example.demo.model.Sala;
import com.example.demo.repository.EscolaRepository;
import com.example.demo.repository.SalaRepository;
import com.example.demo.service.EscolaService;
import com.example.demo.utils.enums.ErrorTypes;
import com.example.demo.utils.misc.ClearningData;
import com.example.demo.utils.security.ObjectNotFoundInSearchOrRuntimeError;
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
    public Escola saveEscola(Escola escola) {
        return this.escolaRepository.save(escola);
    }

    @Override
    public List<Escola> findAll() {
        List<Escola> allEscolas = this.escolaRepository.findAll();
        if(allEscolas.isEmpty())
            return new ArrayList<>();
        else
            return allEscolas;
    }

    @Override
    public Escola findById(String id) {
        if (this.escolaRepository.findById(Long.valueOf(id)).isPresent()) {
            return this.escolaRepository.findById(Long.valueOf(id)).get();
        }
        throw new ObjectNotFoundInSearchOrRuntimeError(ErrorTypes.OBJETO_NAO_LOCALIZADO.toString());
    }

    @Override
    public Escola updateEscola(String id, String nomeEscola) {
        Escola escola = this.findById(id);
        escola.setNomeEscola(nomeEscola);
        ClearningData.correctDataInField(null,null,escola);
        return this.escolaRepository.save(escola);
    }

    @Override
    public void deleteEscola(String id) {
        if(this.escolaRepository.findById(Long.valueOf(id)).isPresent()){
            this.escolaRepository.delete(this.escolaRepository.findById(Long.valueOf(id)).get());
        }
        throw new ObjectNotFoundInSearchOrRuntimeError(ErrorTypes.OBJETO_NAO_LOCALIZADO.toString());
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
