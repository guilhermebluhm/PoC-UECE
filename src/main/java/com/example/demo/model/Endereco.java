package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Entity(name = "tbl_endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "logradouro", nullable = false, length = 200)
    private String logradouro;
    @Column(name = "numero", nullable = false, length = 6)
    private String numero;
    @Column(name = "bairro", nullable = false, length = 50)
    private String bairro;
    @Column(name = "cidade", nullable = false, unique = true, length = 100)
    private String cidade;
    @Column(name = "estado", nullable = false, unique = true, length = 100)
    private String estado;
    @Column(name = "codigo", nullable = false, unique = true, length = 100)
    private String codigo;

    public Endereco(String logradouro, String numero, String bairro, String cidade, String estado, String codigo) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.codigo = codigo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
