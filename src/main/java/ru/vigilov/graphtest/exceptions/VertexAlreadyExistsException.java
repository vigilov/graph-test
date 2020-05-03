package ru.vigilov.graphtest.exceptions;

public class VertexAlreadyExistsException extends GraphIntegrityException {
    private static final long serialVersionUID = 1L;

    public VertexAlreadyExistsException() {
        super("vertex already exists");
    }
}