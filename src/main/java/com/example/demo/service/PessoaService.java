package com.example.demo.service;

import com.example.demo.model.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa saveModel(Pessoa colaborador);
    List<Pessoa> findAll();
    Pessoa findById(String id);
    void updateModel(String id, String numeroTelefone, String cargo);
    void deleteModel(String id);
}
