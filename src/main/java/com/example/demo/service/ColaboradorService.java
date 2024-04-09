package com.example.demo.service;

import com.example.demo.model.Colaborador;
import com.example.demo.model.Endereco;

import java.util.List;

public interface ColaboradorService {

    Colaborador saveModel(Colaborador endereco);
    List<Colaborador> findAll();
    Colaborador findById(String id);
    void updateModel(String id, String numero);
    void deleteModel(String id);

}
