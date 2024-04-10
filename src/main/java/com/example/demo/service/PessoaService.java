package com.example.demo.service;

import com.example.demo.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PessoaService {

    Pessoa saveModel(Pessoa colaborador);
    List<Pessoa> findAll();
    Pessoa findById(String id);
    Pessoa updateModel(String id, String numeroTelefone, String cargo);
    void deleteModel(String id);
}
