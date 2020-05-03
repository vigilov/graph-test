package ru.vigilov.graphtest.graph;

import java.util.Set;

import ru.vigilov.graphtest.exceptions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

abstract class AbstractGraph implements BaseGraph {

    protected final Map<Vertex, Set<Edge>> vertices;

    protected final Set<Edge> edges;

    public AbstractGraph() {
        this.vertices = new HashMap<>();
        this.edges = new HashSet<>();
    }

    /**
     * @throws VertexAlreadyExistsException
     */
    public void addVertex(String vertexName) {
        Vertex vertex = new Vertex(vertexName);

        if (vertices.containsKey(vertex)) {
            throw new VertexAlreadyExistsException();
        }

        vertices.put(vertex, new HashSet<>());
    }

    /**
     * @throws EdgeAlreadyExistsException
     * @throws VertexNotExistsException
     */
    @Override
    public void addEdge(final String vertexAName, final String vertexBName) {
        final Vertex vertexA = new Vertex(vertexAName);
        final Vertex vertexB = new Vertex(vertexBName);

        if (!vertices.containsKey(vertexA) || !vertices.containsKey(vertexB)) {
            throw new VertexNotExistsException();
        }

        final Edge edge = new Edge(vertexA, vertexB);

        if (edges.contains(edge)) {
            throw new EdgeAlreadyExistsException();
        }

        vertices.get(vertexA).add(edge);
        vertices.get(vertexB).add(edge);

        this.edges.add(edge);
    }
}
