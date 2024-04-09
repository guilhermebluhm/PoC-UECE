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
public class Escola implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_escola", nullable = false, length = 200, unique = true)
    private String nomeEscola;

    @OneToOne(fetch = FetchType.EAGER)
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.EAGER)
    private Colaborador funcionario;

    public Escola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Colaborador getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Colaborador funcionario) {
        this.funcionario = funcionario;
    }
}
