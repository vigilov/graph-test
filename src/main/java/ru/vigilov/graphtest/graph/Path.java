package ru.vigilov.graphtest.graph;

import java.util.LinkedHashSet;

public class Path extends LinkedHashSet<Vertex> implements Comparable<Path> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Path() {
        super();
    }

    public Path(Path path) {
        super(path);
    }

    // Shortest path first
    @Override
    public int compareTo(Path o) {
        if (o == this)
            return 0;
        return this.size() - o.size();
    }

    @Override
    public String toString() {
        StringBuilder pathStrBuilder = new StringBuilder();
        Vertex targetVertex = (Vertex) this.toArray()[this.size() - 1];

        this.forEach((Vertex v) -> {
            pathStrBuilder.append(v.getName());

            if (!targetVertex.equals(v)) {
                pathStrBuilder.append(" -> ");
            }
        });

        return pathStrBuilder.toString();
    }
}