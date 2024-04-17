package com.example.demo.utils.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ObjectErrorNotFoundHandler {

    @ExceptionHandler(ObjectNotFoundInSearchOrRuntimeError.class)
    public ResponseEntity<FieldForHandlerError> objectErrorNotFoundHandler(ObjectNotFoundInSearchOrRuntimeError e,
                                                                           HttpServletRequest req){
        FieldForHandlerError err = new FieldForHandlerError(LocalDateTime.now(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                e.getMessage(),
                req.getRequestURI());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }

}
