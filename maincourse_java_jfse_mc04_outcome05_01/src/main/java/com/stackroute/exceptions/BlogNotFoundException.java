package com.stackroute.exceptions;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String message){
        super(message);
    }

    public BlogNotFoundException(){

    }
}
