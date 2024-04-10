package com.example.demo.service;

import com.example.demo.model.Cidade;
import org.springframework.stereotype.Service;

@Service
public interface CidadeService {

    Cidade addCidade(Cidade cidade);
    void removeCidade(String idCidade);

}
