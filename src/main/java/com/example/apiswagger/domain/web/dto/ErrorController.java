package com.example.apiswagger.domain.web.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(Exception.class)
    private ResponseEntity handleInternalError(Exception ex) {
        return ResponseEntity.internalServerError().body(
                new MessageDto("Необработанная ошибка: " + ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity methodMismatch(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new MessageDto("Ошибка в ссылке: " + ex.getMessage()));
    }
}
