package com.example.demo.utils.security;

public class ObjectNotFoundInSearchOrRuntimeError extends RuntimeException {

    public ObjectNotFoundInSearchOrRuntimeError(String message){
        super(message);
    }

}
