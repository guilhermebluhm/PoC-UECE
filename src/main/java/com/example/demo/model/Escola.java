package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tbl_escola")
public class Escola implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_escola", nullable = false, length = 200, unique = true)
    private String nomeEscola;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sala")
    private Sala sala;

    public Escola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
