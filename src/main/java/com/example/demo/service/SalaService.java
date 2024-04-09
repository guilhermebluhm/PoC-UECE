package com.example.demo.service;

import com.example.demo.model.Sala;

import java.util.List;

public interface SalaService {

    Sala adicionarSala(Sala sala);
    void removerSala(String idSala);
    void adicionarSalaEscola(String idSala, String idEscola);
    List<Sala> todasSalas();

}
