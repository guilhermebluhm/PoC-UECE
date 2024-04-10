package com.example.demo.service;

import com.example.demo.model.Sala;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalaService {

    Sala adicionarSala(Sala sala);
    void removerSala(String idSala);
    List<Sala> todasSalas();

}
