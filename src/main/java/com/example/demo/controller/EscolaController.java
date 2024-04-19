package com.example.demo.controller;

import com.example.demo.model.Escola;
import com.example.demo.service.Impl.EscolaServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/escola")
public class EscolaController {

    @Autowired
    private EscolaServiceImpl escolaImpl;
    private final Gson gson = new Gson();

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveEscola(@RequestBody Escola escola){
        return ResponseEntity.status(HttpStatus.CREATED).body(new Gson().toJson(this.escolaImpl.saveEscola(escola)));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateEscola(@PathVariable String id, @RequestParam("nome") String nome){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.escolaImpl.updateEscola(id, nome)));
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> allEscola(){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.escolaImpl.findAll()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findSpecificEscola(@PathVariable String id){

        String jsonResponse = gson.toJson(this.escolaImpl.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteEscola(@PathVariable String id){
        this.escolaImpl.deleteEscola(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

/*    @PostMapping(value = "/add-sala/{id}")
    public ResponseEntity<String> addSalaEscola(@PathVariable("id") String idEscola,
                                                @RequestParam(value = "salaID") String idSala){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.escolaImpl.addSalaEscola(idEscola,idSala)));
    }*/
}
