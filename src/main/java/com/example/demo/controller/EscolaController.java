package com.example.demo.controller;

import com.example.demo.model.Endereco;
import com.example.demo.model.Escola;
import com.example.demo.service.Impl.EscolaServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/escola")
public class EscolaController {

    @Autowired
    private EscolaServiceImpl esc;

    @PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveEscola(@RequestBody Escola escola){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.esc.saveModel(escola)));
    }

    @PutMapping(value = "/atualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEscola(@PathVariable String id, @RequestParam("nome") String nome){
        this.esc.updateModel(id, nome);
    }

    @GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Escola> allEscola(){
        return this.esc.findAll();
    }

    @GetMapping(value = "/especifico/{id}")
    public String findByEscola(@PathVariable String id){
        return new Gson().toJson(this.esc.findById(id));
    }

    @DeleteMapping(value = "/deletar")
    public void deleteEscola(@RequestParam String id){
        this.esc.deleteModel(id);
    }

}
