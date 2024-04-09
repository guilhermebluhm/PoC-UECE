package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Entity(name = "tbl_candidato")
public class Candidato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_candidato", length = 6, nullable = false)
    private String numeroCandidato;
    @Column(name = "nome_candidato", length = 50, nullable = false)
    private String nomeCandidato;
    @Column(name = "tem_deficiencia")
    private boolean deficiencia;

    public Candidato(String numeroCandidato, String nomeCandidato, boolean deficiencia) {
        this.numeroCandidato = numeroCandidato;
        this.nomeCandidato = nomeCandidato;
        this.deficiencia = deficiencia;
    }

    public String getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(String numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public boolean isDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(boolean deficiencia) {
        this.deficiencia = deficiencia;
    }
}
