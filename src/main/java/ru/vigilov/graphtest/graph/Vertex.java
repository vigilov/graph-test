package ru.vigilov.graphtest.graph;

import java.util.Objects;

public class Vertex {

    private final String name;

    Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vertex)) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}