package com.example.apiswagger.domain.web.dto;

import jakarta.persistence.EntityNotFoundException;

import java.nio.file.FileAlreadyExistsException;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CustomExceptions extends RuntimeException {
    public CustomExceptions(String message) {
        super(message);
    }

    public static Supplier<EntityNotFoundException> IdsNotFound(Class myClass, Collection<Long> id) {
        return () -> new EntityNotFoundException(myClass.getSimpleName() + "s with ID " + id.stream().map(Object::toString).collect(Collectors.joining(",")) + " not found");
    }
    public static Supplier<EntityNotFoundException> IdNotFound(Class myClass,Long id) {
        return () -> new EntityNotFoundException(myClass.getSimpleName() + " with ID " + id + " not found");
    }
    public static Supplier<FileAlreadyExistsException> FileAlreadyExists(String name) {
        return () -> new FileAlreadyExistsException("File with name " + name +" already exists");
    }
    public static Supplier<FileAlreadyExistsException> FileNotFound(String name) {
        return () -> new FileAlreadyExistsException("File with name " + name +" not found");
    }
}
