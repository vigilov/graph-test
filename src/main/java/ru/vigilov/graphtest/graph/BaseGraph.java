package ru.vigilov.graphtest.graph;

public interface BaseGraph {

    void addVertex(String name);

    void addEdge(String firstVertexName, String secondVertexName);

    Path getPath(String vertexAName, String vertexBName);
}
