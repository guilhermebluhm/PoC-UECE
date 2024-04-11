package com.example.demo.utils.misc;

import com.example.demo.model.Pessoa;
import com.example.demo.utils.enums.ErrorTypes;
import com.example.demo.utils.security.ObjectMalformed;
import com.example.demo.utils.security.ObjectNotFoundInSearch;

public class ClearningData {

    public static final String REGEX_VALIDATE_CPF_CNPJ = "^(((\\d{3}).(\\d{3}).(\\d{3})-(\\d{2}))?((\\d{2}).(\\d{3}).(\\d{3})/(\\d{4})-(\\d{2}))?)*$";
    public static final String CLEAR_REGEX_CPF_CNPJ = "[\\.\\-\\/]";

    public static Pessoa teste(Pessoa pessoa){

        int bp = 99;
        if(pessoa.getCargo() == null
                || (pessoa.getMatricula() == null || pessoa.getMatricula().isEmpty())
                || (pessoa.getNome() == null || pessoa.getNome().isEmpty())
                || (pessoa.getTelefone() == null || pessoa.getTelefone().isEmpty())){

            throw new ObjectNotFoundInSearch(ErrorTypes.MAL_FORMACAO_OBJETO.toString());

        }

        if(pessoa.getDocumento().length() == 14 || pessoa.getDocumento().length() == 18){
            if(!pessoa.getDocumento().matches(REGEX_VALIDATE_CPF_CNPJ))
                throw new ObjectMalformed(ErrorTypes.CPF_CNPJ_INVALIDO.toString());
        }

        pessoa.setDocumento(pessoa.getDocumento().replaceAll(CLEAR_REGEX_CPF_CNPJ, ""));
        return pessoa;

    }

}
