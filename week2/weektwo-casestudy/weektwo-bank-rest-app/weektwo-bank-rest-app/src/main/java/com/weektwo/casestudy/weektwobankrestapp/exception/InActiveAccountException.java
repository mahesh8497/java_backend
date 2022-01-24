package com.weektwo.casestudy.weektwobankrestapp.exception;

public class InActiveAccountException extends RuntimeException {

    public InActiveAccountException (String message) {
        super(message);
    }
}
