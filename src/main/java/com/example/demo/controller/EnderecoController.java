package com.example.demo.controller;

import com.example.demo.model.Endereco;
import com.example.demo.service.Impl.EnderecoServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl endImpl;

    @PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveEndereco(@RequestBody Endereco endereco){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.endImpl.saveModel(endereco)));
    }

    @PutMapping(value = "/atualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEndereco(@PathVariable String id, @RequestParam("numero") String numero){
        this.endImpl.updateModel(id, numero);
    }

    @GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public String allEnderecos(){
        return new Gson().toJson(this.endImpl.findAll());
    }

    @GetMapping(value = "/especifico/{id}")
    public String findByEndereco(@PathVariable String id){
        return new Gson().toJson(this.endImpl.findById(id));
    }

    @DeleteMapping(value = "/deletar")
    public void deleteEndereco(@RequestParam String id){
        this.endImpl.deleteModel(id);
    }
}
