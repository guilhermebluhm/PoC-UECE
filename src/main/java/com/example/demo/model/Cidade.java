package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 100)
    private String cidade;
    @Column(unique = true, length = 100)
    private String estado;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Endereco> listaEnderecos = new ArrayList<>();

    public Cidade(String cidade, String estado) {
        this.cidade = cidade;
        this.estado = estado;
    }

}
