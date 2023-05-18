package com.example.apiswagger.domain.web.dto;

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
