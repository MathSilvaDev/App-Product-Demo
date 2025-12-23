package com.example.products.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHundlerException {

    @ExceptionHandler(NotFindByIdException.class)
    public ResponseEntity<String> notFindByIdException(NotFindByIdException ex){
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(
            MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {
                    errors.put(
                            error.getField(),
                            error.getDefaultMessage()
                    );
                });

        return ResponseEntity.badRequest().body(errors);
    }


}
