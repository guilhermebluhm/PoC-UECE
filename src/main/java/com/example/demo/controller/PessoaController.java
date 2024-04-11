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
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaServiceImpl pessoaImpl;

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> savePessoa(@RequestBody(required = false) Pessoa pessoa){

        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.pessoaImpl.saveModel(pessoa)));

    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePessoa(@PathVariable String id,
                               @RequestParam(value = "numero-telefone", required = false) String numeroTelefone,
                               @RequestParam(value = "cargo") String cargo){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.pessoaImpl.updateModel(id, numeroTelefone, cargo)));
    }

    @GetMapping(value = "/allRegistry", produces = MediaType.APPLICATION_JSON_VALUE)
    public String allPessoa(){
        return new Gson().toJson(this.pessoaImpl.findAll());
    }

    @GetMapping(value = "/specific/{id}")
    public String findSpecificPessoa(@PathVariable String id){
        return new Gson().toJson(this.pessoaImpl.findById(id));
    }

    @DeleteMapping(value = "/delete")
    public void deleteEndereco(@RequestParam String id){
        this.pessoaImpl.deleteModel(id);
    }

}
