package com.example.products.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHundlerException {

    @ExceptionHandler(NotFindByIdException.class)
    public ResponseEntity<String> notFindByIdException(NotFindByIdException e){
        return ResponseEntity
                .badRequest()
                .body(e.getMessage());
    }
}
