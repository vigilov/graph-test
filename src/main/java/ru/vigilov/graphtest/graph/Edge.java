package ru.vigilov.graphtest.graph;

import java.util.Objects;

public class Edge {

    private final Vertex vertexA;

    private final Vertex vertexB;

    public Edge(Vertex vertexA, Vertex vertexB) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
    }

    public Vertex getVertexA() {
        return vertexA;
    }

    public Vertex getVertexB() {
        return vertexB;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Edge)) {
            return false;
        }
        Edge edge = (Edge) o;
        return Objects.equals(vertexA, edge.vertexA) && Objects.equals(vertexB, edge.vertexB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexA, vertexB);
    }
}