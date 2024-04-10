package com.example.demo.controller;

import com.example.demo.model.Cidade;
import com.example.demo.service.Impl.CidadeServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeServiceImpl cidade;

    @PostMapping(value = "/save")
    public ResponseEntity<String> addCidade(@RequestBody Cidade cidade){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.cidade.adicionarCidade(cidade)));
    }

    @DeleteMapping(value = "/delete")
    public void remCidade(String idCidade){
        this.cidade.removerCidade(idCidade);
    }

}
