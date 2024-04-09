package com.example.demo.controller;

import com.example.demo.model.Escola;
import com.example.demo.model.Sala;
import com.example.demo.service.Impl.SalaServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/salas")
public class SalaController {

    @Autowired
    private SalaServiceImpl sl;

    @PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveEscola(@RequestBody Sala sala){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.sl.adicionarSala(sala)));
    }

    @GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sala> allEscola(){
        return this.sl.todasSalas();
    }

    @DeleteMapping(value = "/deletar")
    public void deleteEscola(@RequestParam String id){
        this.sl.removerSala(id);
    }

}
