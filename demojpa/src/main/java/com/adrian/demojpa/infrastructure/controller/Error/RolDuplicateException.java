package com.adrian.demojpa.infrastructure.controller.Error;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class RolDuplicateException extends RuntimeException {

    private String message;
    private HttpStatus statusCode;
    
    public RolDuplicateException(String message, HttpStatus statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }
}
