package com.example.demo.utils.enums;

public enum RegexTypes {

    REGEX_VALIDATE_CPF_CNPJ("^(((\\d{3}).(\\d{3}).(\\d{3})-(\\d{2}))?((\\d{2}).(\\d{3}).(\\d{3})/(\\d{4})-(\\d{2}))?)*$"),
    CLEAR_REGEX_CPF_CNPJ("[\\.\\-\\/]"),
    CHECK_REGEX_TO_ONLY_ALPHABETIC("^[a-zA-Z]+$"),
    CHECK_REGEX_TO_ONLY_NUMERIC("^[0-9]+$");

    private final String codeType;

    RegexTypes(String code){
        this.codeType = code;
    }



}
