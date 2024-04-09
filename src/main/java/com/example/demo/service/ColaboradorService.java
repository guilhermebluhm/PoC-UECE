package com.example.demo.service;

import com.example.demo.model.Colaborador;
import com.example.demo.model.Endereco;

import java.util.List;

public interface ColaboradorService {

    Colaborador saveModel(Colaborador colaborador);
    List<Colaborador> findAll();
    Colaborador findById(String id);
    void updateModel(String id, String numeroTelefone, String cargo);
    void deleteModel(String id);
    void adicionarColaboradorEscola(String idColaborador, String idEscola);
}
