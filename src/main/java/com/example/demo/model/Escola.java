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

    private Boolean disponivel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sala_id", referencedColumnName = "id")
    private List<Sala> listaSala = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    public Cidade cidade;

    public Escola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public List<Sala> getListaSala() {
        return listaSala;
    }

    public void setListaSala(List<Sala> listaSala) {
        this.listaSala = listaSala;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
