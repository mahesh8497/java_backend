package com.weektwo.casestudy.weektwobankrestapp.exception;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(String message) {
        super(message);
    }
}