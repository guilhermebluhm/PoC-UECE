package com.example.demo.utils.misc;

import com.example.demo.model.Cidade;
import com.example.demo.model.Pessoa;
import com.example.demo.utils.enums.ErrorTypes;
import com.example.demo.utils.enums.RegexTypes;
import com.example.demo.utils.security.ObjectMalformed;

public class ClearningData {

    public static Pessoa integratyCheck(Pessoa pessoa){

        pessoa.setTelefone(RemoveWhiteSpacesAndMergeDataToValidate.getData(pessoa.getTelefone()));
        pessoa.setDocumento(RemoveWhiteSpacesAndMergeDataToValidate.getData(pessoa.getDocumento()));
        pessoa.setMatricula(RemoveWhiteSpacesAndMergeDataToValidate.getData(pessoa.getMatricula()));

        checkIntegrityData(pessoa);
        correctDataInField(pessoa, null);

        if(pessoa.getDocumento().length() == 14 || pessoa.getDocumento().length() == 18){
            if(!pessoa.getDocumento().matches(RegexTypes.REGEX_VALIDATE_CPF_CNPJ.getCodeType()))
                throw new ObjectMalformed(ErrorTypes.CPF_CNPJ_INVALIDO.toString());
        }

        pessoa.setDocumento(pessoa.getDocumento().replaceAll(RegexTypes.CLEAR_REGEX_CPF_CNPJ.toString(), ""));
        return pessoa;

    }

    public static void checkIntegrityData(Pessoa pessoa){

        if((pessoa.getCargo() == null || pessoa.getCargo().isEmpty())
                || (pessoa.getMatricula() == null || pessoa.getMatricula().isEmpty())
                || (pessoa.getNome() == null || pessoa.getNome().isEmpty())
                || (pessoa.getTelefone() == null || pessoa.getTelefone().isEmpty())){

            throw new ObjectMalformed(ErrorTypes.MAL_FORMACAO_OBJETO.toString());

        }

    }

    public static void correctDataInField(Pessoa pessoa, Cidade cidade){
        if(pessoa != null) {
            if (
                    !RemoveWhiteSpacesAndMergeDataToValidate.getData(pessoa.getNome())
                            .matches(RegexTypes.CHECK_REGEX_TO_ONLY_ALPHABETIC.getCodeType())
                            || !RemoveWhiteSpacesAndMergeDataToValidate.getData(pessoa.getCargo())
                            .matches(RegexTypes.CHECK_REGEX_TO_ONLY_ALPHABETIC.getCodeType())
                            || !pessoa.getTelefone().trim()
                            .matches(RegexTypes.CHECK_REGEX_TO_ONLY_NUMERIC.getCodeType())
                            || !pessoa.getMatricula()
                            .matches(RegexTypes.CHECK_REGEX_TO_ONLY_NUMERIC.getCodeType())
            ) {
                throw new ObjectMalformed(ErrorTypes.DADOS_INVALIDOS_NO_OBJETO.toString());
            }
        }
        else if(cidade != null){

            if (
                            !RemoveWhiteSpacesAndMergeDataToValidate.getData(cidade.getCidade())
                                    .matches(RegexTypes.CHECK_REGEX_TO_ONLY_ALPHABETIC.getCodeType())
                            || !RemoveWhiteSpacesAndMergeDataToValidate.getData(cidade.getEstado())
                                    .matches(RegexTypes.CHECK_REGEX_TO_ONLY_ALPHABETIC.getCodeType())
                            || !RemoveWhiteSpacesAndMergeDataToValidate.getData(cidade.getEndereco().getBairro())
                                    .matches(RegexTypes.CHECK_REGEX_TO_ONLY_ALPHABETIC.getCodeType())
                            || !RemoveWhiteSpacesAndMergeDataToValidate.getData(cidade.getEndereco().getCep())
                                    .matches(RegexTypes.CHECK_REGEX_TO_ONLY_NUMERIC.getCodeType())
                            || !RemoveWhiteSpacesAndMergeDataToValidate.getData(cidade.getEndereco().getLogradouro())
                                    .matches(RegexTypes.CHECK_REGEX_TO_ALPHABETIC_AND_NUMERIC.getCodeType())
            ) {
                throw new ObjectMalformed(ErrorTypes.DADOS_INVALIDOS_NO_OBJETO.toString());
            }
        }
    }

}
