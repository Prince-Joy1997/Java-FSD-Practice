package com.stackroute.exceptions;

public class BlogAlreadyExistsException extends RuntimeException{
    public BlogAlreadyExistsException(String message){

        super(message);
    }
    public BlogAlreadyExistsException(){

    }
}
