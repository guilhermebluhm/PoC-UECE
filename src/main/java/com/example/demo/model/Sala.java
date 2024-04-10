package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tbl_sala")
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10, nullable = false, unique = true)
    private String numero;
    @Column(nullable = false)
    private Long coordenacao;
    @Column(nullable = false)
    private Long totalCandidatos;
    @Column(length = 10, nullable = false)
    private String salaEscola;
    @Column(length = 10, nullable = false)
    private String salaCev;

}
