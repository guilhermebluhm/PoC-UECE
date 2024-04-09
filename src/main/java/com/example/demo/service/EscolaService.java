package com.example.demo.service;

import com.example.demo.model.Endereco;
import com.example.demo.model.Escola;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EscolaService {

    Escola saveModel(Escola endereco);
    List<Escola> findAll();
    Escola findById(String id);
    void updateModel(String id, String nomeEscola);
    void deleteModel(String id);
    Escola adicionarEnderecoEscola(String idEscola, String idEndereco);

}
