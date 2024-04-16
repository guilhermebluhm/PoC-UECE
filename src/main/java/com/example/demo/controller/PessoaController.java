package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.service.Impl.PessoaServiceImpl;
import com.example.demo.utils.security.ObjectMalformed;
import com.example.demo.utils.security.ObjectNotFoundInSearchOrRuntimeError;
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

    private final Gson gson = new Gson();

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> savePessoa(@RequestBody(required = false) Pessoa pessoa){

        String jsonResponse = gson.toJson(this.pessoaImpl.savePessoa(pessoa));
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePessoa(
                               @PathVariable String id,
                               @RequestParam(value = "numero-telefone", required = false) String numeroTelefone,
                               @RequestParam(value = "cargo") String cargo){

        String jsonResponse = gson.toJson(this.pessoaImpl
                .updatePessoa(id, numeroTelefone, cargo));

        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);

    }

    @GetMapping(value = "/all-registry", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> allPessoa(){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.pessoaImpl.findAll()));
    }

    @GetMapping(value = "/specific/{id}")
    public ResponseEntity<String> findSpecificPessoa(@PathVariable String id){

        String jsonResponse = gson.toJson(this.pessoaImpl.findByIdPessoa(id));
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deletePessoa(@PathVariable String id){
        try {
            this.pessoaImpl.deletePessoa(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson("registro deletado com sucesso !"));
        }
        catch (ObjectNotFoundInSearchOrRuntimeError e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Gson().toJson(e.getMessage()));
        }
    }

}
