package com.example.demo.service;

import com.example.demo.model.Endereco;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnderecoService {

    Endereco saveModel(Endereco endereco);
    List<Endereco> findAll();
    Endereco findById(String id);
    void updateModel(String id, String numero);
    void deleteModel(String id);

}
