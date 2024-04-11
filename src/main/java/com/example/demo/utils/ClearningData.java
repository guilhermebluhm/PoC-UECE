package com.example.demo.utils;

import com.example.demo.model.Pessoa;
import com.example.demo.utils.security.MalformCpfToPessoa;
import com.example.demo.utils.security.ObjectErrorNotFoundHandler;
import com.example.demo.utils.security.ObjectMalformed;
import com.example.demo.utils.security.ObjectNotFoundInSearch;

import java.util.regex.Matcher;

public class ClearningData {

    public static final String REGEX_VALIDATE_CPF_CNPJ = "^(((\\d{3}).(\\d{3}).(\\d{3})-(\\d{2}))?((\\d{2}).(\\d{3}).(\\d{3})/(\\d{4})-(\\d{2}))?)*$";

    public static Pessoa teste(Pessoa pessoa){



        if(pessoa.getCargo() == null
                || (pessoa.getMatricula() == null && pessoa.getMatricula().isBlank())
                || (pessoa.getNome() == null && !pessoa.getNome().isBlank())
                || (pessoa.getTelefone() == null && !pessoa.getTelefone().isBlank())){

            if(pessoa.getDocumento().length() == 11 || pessoa.getDocumento().length() == 14){
                if(!pessoa.getDocumento().matches(REGEX_VALIDATE_CPF_CNPJ))
                    throw new ObjectMalformed("CPF/CNPJ invalido");
            }

            throw new ObjectNotFoundInSearch("erro geral na montagem do object");

        }

        return pessoa;

    }

}
