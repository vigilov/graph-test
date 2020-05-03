package ru.vigilov.graphtest.exceptions;

public class VertexNotExistsException extends GraphIntegrityException {
    private static final long serialVersionUID = 1L;

    public VertexNotExistsException() {
        super("vertex not exists");
    }
}