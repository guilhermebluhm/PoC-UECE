package com.example.demo.service;

import com.example.demo.model.Cidade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CidadeService {

    Cidade saveCidade(Cidade cidade);
    void deleteCidade(String idCidade);
    List<Cidade> findAll();

}
