package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Entity(name = "tbl_escola")
public class Escola implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_escola", nullable = false, length = 200, unique = true)
    private String nomeEscola;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Sala> listaSala = new ArrayList<>();

    public Escola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public List<Sala> getListaSala() {
        return listaSala;
    }

    public void setListaSala(Sala sala) {
        this.listaSala.add(sala);
    }
}
