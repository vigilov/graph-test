package ru.vigilov.graphtest.exceptions;

public class EdgeAlreadyExistsException extends GraphIntegrityException {
    private static final long serialVersionUID = 1L;

    public EdgeAlreadyExistsException() {
        super("edge already not exists");
    }
}