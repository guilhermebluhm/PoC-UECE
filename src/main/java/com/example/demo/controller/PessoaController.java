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

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> savePessoa(@RequestBody(required = false) Pessoa pessoa){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.pessoaImpl.savePessoa(pessoa)));
        }
        catch (ObjectMalformed e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Gson().toJson(this.pessoaImpl.savePessoa(pessoa)));
        }
        catch (ObjectNotFoundInSearchOrRuntimeError e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Gson().toJson(this.pessoaImpl.savePessoa(pessoa)));
        }
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePessoa(@PathVariable String id,
                               @RequestParam(value = "numero-telefone", required = false) String numeroTelefone,
                                               @RequestParam(value = "cargo") String cargo){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Gson()
                            .toJson(this.pessoaImpl
                                    .updatePessoa(id, numeroTelefone, cargo)));
        }
        catch (ObjectNotFoundInSearchOrRuntimeError e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new Gson()
                            .toJson(this.pessoaImpl
                                    .updatePessoa(id, numeroTelefone, cargo)));
        }
        catch (ObjectMalformed e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Gson()
                            .toJson(this.pessoaImpl
                                    .updatePessoa(id, numeroTelefone, cargo)));
        }
    }

    @GetMapping(value = "/all-registry", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> allPessoa(){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.pessoaImpl.findAll()));
    }

    @GetMapping(value = "/specific/{id}")
    public ResponseEntity<String> findSpecificPessoa(@PathVariable String id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.pessoaImpl.findByIdPessoa(id)));
        }
        catch (ObjectNotFoundInSearchOrRuntimeError e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Gson().toJson(this.pessoaImpl.findByIdPessoa(id)));
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deletePessoa(@RequestParam String id){
        this.pessoaImpl.deletePessoa(id);
        return ResponseEntity.status(HttpStatus.OK).body("deletado com sucesso");
    }

}
