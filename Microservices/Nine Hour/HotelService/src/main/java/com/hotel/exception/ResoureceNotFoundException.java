package com.hotel.exception;

public class ResoureceNotFoundException extends RuntimeException{

    public ResoureceNotFoundException(String s){
        super(s);
    }

    public ResoureceNotFoundException(){
        super("Resource not found exception");
    }
}
