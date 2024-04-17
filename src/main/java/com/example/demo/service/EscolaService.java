package com.example.demo.service;

import com.example.demo.model.Endereco;
import com.example.demo.model.Escola;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EscolaService {

    Escola saveEscola(Escola endereco);
    List<Escola> findAll();
    Escola findById(String id);
    Escola updateEscola(String id, String nomeEscola);
    void deleteEscola(String id);
    //Escola addSalaEscola(String idEscola, String idSala);

}
