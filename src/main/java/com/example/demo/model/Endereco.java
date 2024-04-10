package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Endereco implements Serializable {

    private String logradouro;
    private String bairro;
    private String cep;

    public Endereco(String logradouro, String bairro, String cep) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
    }

}
