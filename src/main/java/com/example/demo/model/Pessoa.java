package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tbl_pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, unique = true, nullable = false)
    private String nome;
    @Column(length = 25, unique = true, nullable = false)
    private String matricula;
    @Column(length = 50, unique = true, nullable = false)
    private String cargo;
    @Column(length = 11, unique = true, nullable = false)
    private String telefone;
    @Column(length = 15, unique = true, nullable = false)
    private String cpf;

    //sera definido posteriormente
    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "funcionario")
    //private List<Escola> escolas = new ArrayList<>();


    public Pessoa(String nome, String matricula, String cargo, String telefone, String cpf) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
        this.telefone = telefone;
        this.cpf = cpf;
    }
}
