package com.example.demo.utils;

import com.example.demo.model.Pessoa;
import com.example.demo.utils.security.ObjectNotFoundInSearch;

public class ClearningData {

    public static Pessoa teste(Pessoa pessoa){

        if(pessoa.getCargo() == null
                || pessoa.getMatricula() == null
                || pessoa.getNome() == null){

            throw new ObjectNotFoundInSearch("erro geral na montagem do object");

        }

        return pessoa;

    }

}
