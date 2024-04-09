package com.example.demo.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity(name = "tbl_colaborador")
public class Colaborador implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "funcionario")
    private List<Escola> escolas = new ArrayList<>();

    public Colaborador(String nome, String matricula, String cargo) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void addEscola(Escola escola){
        escolas.add(escola);
        escola.setFuncionario(this);
    }

    public void remEscola(Escola escola){
        escolas.remove(escola);
        escola.setFuncionario(null);
    }

}
