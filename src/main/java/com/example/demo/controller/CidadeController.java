package com.example.demo.controller;

import com.example.demo.model.Cidade;
import com.example.demo.service.Impl.CidadeServiceImpl;
import com.example.demo.utils.security.ObjectNotFoundInSearchOrRuntimeError;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

    @Autowired
    private CidadeServiceImpl cidadeImpl;
    private final Gson gson = new Gson();

/*    @PostMapping(value = "/save")
    public ResponseEntity<String> saveCidade(@RequestBody Cidade cidade){

        String jsonResponse = gson.toJson(this.cidadeImpl.saveCidade(cidade));
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }*/

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeCidade(@PathVariable String id){
        try {
            this.cidadeImpl.deleteCidade(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson("registro deletado com sucesso !"));
        }
        catch (ObjectNotFoundInSearchOrRuntimeError e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Gson().toJson(e.getMessage()));
        }
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> allCidade(){
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(this.cidadeImpl.findAll()));
    }

}
