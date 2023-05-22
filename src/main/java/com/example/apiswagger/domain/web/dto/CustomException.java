package com.example.apiswagger.domain.web.dto;

import jakarta.persistence.EntityNotFoundException;

import java.lang.reflect.Type;
import java.util.function.Supplier;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }

    public static Supplier<EntityNotFoundException> IdNotFound(Type type) {
        return () -> new EntityNotFoundException(type.getTypeName() + " with ID \" + id + \" not found");
    }
}
