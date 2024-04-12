package com.example.demo.service;

import com.example.demo.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PessoaService {

    Pessoa savePessoa(Pessoa colaborador);
    List<Pessoa> findAll();
    Pessoa findByIdPessoa(String id);
    Pessoa updatePessoa(String id, String numeroTelefone, String cargo);
    void deletePessoa(String id);
}
