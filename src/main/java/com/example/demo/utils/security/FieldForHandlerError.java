package com.example.demo.utils.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class FieldForHandlerError {

    private LocalDateTime timestamp;
    private Integer error;
    private String messageError;
    private String path;

}
