package com.User.service.exception;

import com.User.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    private ResponseEntity<ApiResponse>handlerResourceNotfoundException(ResourceNotFound ex)
    {
        String message= ex.getMessage();
     ApiResponse response=   ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);


    }
}
