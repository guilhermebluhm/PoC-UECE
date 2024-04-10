package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.service.Impl.PessoaServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/colaborador")
public class PessoaController {

    @Autowired
    private PessoaServiceImpl colab;

    @PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveColaborador(@RequestBody Pessoa endereco){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.colab.saveModel(endereco)));
    }

    @PutMapping(value = "/atualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateColaborador(@PathVariable String id,
                               @RequestParam(value = "numero-telefone", required = false) String numeroTelefone,
                               @RequestParam(value = "cargo") String cargo){
        this.colab.updateModel(id, numeroTelefone, cargo);
    }

    @GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public String allColaboradores(){
        return new Gson().toJson(this.colab.findAll());
    }

    @GetMapping(value = "/especifico/{id}")
    public String findByEndereco(@PathVariable String id){
        return new Gson().toJson(this.colab.findById(id));
    }

    @DeleteMapping(value = "/deletar")
    public void deleteEndereco(@RequestParam String id){
        this.colab.deleteModel(id);
    }

}
