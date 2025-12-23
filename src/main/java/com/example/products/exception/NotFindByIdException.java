package com.example.products.exception;

public class NotFindByIdException extends RuntimeException{

    public NotFindByIdException(){
        super("ERROR: Id not found");
    }

    public NotFindByIdException(String msg){
        super(msg);
    }
}
