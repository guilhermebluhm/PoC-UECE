package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
public class Endereco implements Serializable {

    private final String logradouro;
    private final String bairro;
    private final String cep;

    public Endereco(String logradouro, String bairro, String cep) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

}
