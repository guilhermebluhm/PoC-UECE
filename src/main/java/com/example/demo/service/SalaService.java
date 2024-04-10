package com.example.demo.service;

import com.example.demo.model.Sala;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalaService {

    Sala addSala(Sala sala);
    void removeSala(String idSala);
    List<Sala> allSalas();

}
