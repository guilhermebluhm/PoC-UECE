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
    private EscolaServiceImpl escolaImpl;

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveEscola(@RequestBody Escola escola){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.escolaImpl.saveModel(escola)));
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEscola(@PathVariable String id, @RequestParam("nome") String nome){
        this.escolaImpl.updateModel(id, nome);
    }

    @GetMapping(value = "/all-registry", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Escola> allEscola(){
        return this.escolaImpl.findAll();
    }

    @GetMapping(value = "/specific/{id}")
    public String findSpecificEscola(@PathVariable String id){
        return new Gson().toJson(this.escolaImpl.findById(id));
    }

    @DeleteMapping(value = "/delete")
    public void deleteEscola(@RequestParam String id){
        this.escolaImpl.deleteModel(id);
    }

    @PostMapping(value = "/add-sala/{idEscola}")
    public ResponseEntity<String> addSalaEscola(@PathVariable("idEscola") String idEscola,
                                                      @RequestParam(value = "salaID") String idSala){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.escolaImpl.adicionarSalaEscola(idEscola,idSala)));
    }
}
