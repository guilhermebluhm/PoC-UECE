package com.example.demo.utils.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MalformCpfToPessoa {

    @ExceptionHandler(ObjectMalformed.class)
    public ResponseEntity<FieldForHandlerError> objectErrorNotFoundHandler(ObjectMalformed e,
                                                                           HttpServletRequest req){
        FieldForHandlerError err = new FieldForHandlerError(LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage(),
                req.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }

}
