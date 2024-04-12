package com.example.demo.utils.misc;

public class RemoveWhiteSpacesAndMergeDataToValidate {

    public static String getData(String value){

        return value.trim().replaceAll(" ","");

    }

}
