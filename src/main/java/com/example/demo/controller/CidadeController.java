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
    private CidadeServiceImpl cidadeImpl;

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveCidade(@RequestBody Cidade cidade){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.cidadeImpl.addCidade(cidade)));
    }

    @DeleteMapping(value = "/delete")
    public void removeCidade(String idCidade){
        this.cidadeImpl.removeCidade(idCidade);
    }

}
