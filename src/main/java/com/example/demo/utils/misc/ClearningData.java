package com.example.demo.utils.misc;

import com.example.demo.model.Pessoa;
import com.example.demo.utils.enums.ErrorTypes;
import com.example.demo.utils.enums.RegexTypes;
import com.example.demo.utils.security.ObjectMalformed;
import com.example.demo.utils.security.ObjectNotFoundInSearch;

public class ClearningData {

    public static Pessoa teste(Pessoa pessoa){

        pessoa.setTelefone(pessoa.getTelefone().replace(" ",""));
        pessoa.setDocumento(pessoa.getDocumento().replace(" ",""));
        pessoa.setMatricula(pessoa.getMatricula().replace(" ",""));

        checkIntegrityData(pessoa);
        correctDataInField(pessoa);

        if(pessoa.getDocumento().length() == 14 || pessoa.getDocumento().length() == 18){
            if(!pessoa.getDocumento().matches(RegexTypes.REGEX_VALIDATE_CPF_CNPJ.toString()))
                throw new ObjectMalformed(ErrorTypes.CPF_CNPJ_INVALIDO.toString());
        }

        pessoa.setDocumento(pessoa.getDocumento().replaceAll(RegexTypes.CLEAR_REGEX_CPF_CNPJ.toString(), ""));
        return pessoa;

    }

    private static void checkIntegrityData(Pessoa pessoa){

        if((pessoa.getCargo() == null || pessoa.getCargo().isEmpty())
                || (pessoa.getMatricula() == null || pessoa.getMatricula().isEmpty())
                || (pessoa.getNome() == null || pessoa.getNome().isEmpty())
                || (pessoa.getTelefone() == null || pessoa.getTelefone().isEmpty())){

            throw new ObjectMalformed(ErrorTypes.MAL_FORMACAO_OBJETO.toString());

        }

    }

    private static void correctDataInField(Pessoa pessoa){

        if(!pessoa.getNome().matches(RegexTypes.CHECK_REGEX_TO_ONLY_ALPHABETIC.toString())
                || !pessoa.getCargo().matches(RegexTypes.CHECK_REGEX_TO_ONLY_ALPHABETIC.toString())
                || !pessoa.getTelefone().matches(RegexTypes.CHECK_REGEX_TO_ONLY_NUMERIC.toString())
                || !pessoa.getMatricula().matches(RegexTypes.CHECK_REGEX_TO_ONLY_NUMERIC.toString())){

            throw new ObjectMalformed(ErrorTypes.DADOS_INVALIDOS_NO_OBJETO.toString());

        }

    }

}
