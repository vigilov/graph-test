package ru.vigilov.graphtest.exceptions;

public class GraphIntegrityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public GraphIntegrityException(String s) {
        super(s);
    }
}