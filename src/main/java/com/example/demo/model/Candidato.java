package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Candidato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_candidato", length = 6, nullable = false)
    private String numeroCandidato;
    @Column(name = "nome_candidato", length = 50, nullable = false)
    private String nomeCandidato;

    public Candidato(String numeroCandidato, String nomeCandidato) {
        this.numeroCandidato = numeroCandidato;
        this.nomeCandidato = nomeCandidato;
    }
}
