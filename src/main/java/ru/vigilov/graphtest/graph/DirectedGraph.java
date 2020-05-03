package ru.vigilov.graphtest.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import ru.vigilov.graphtest.exceptions.GraphIntegrityException;

public class DirectedGraph extends AbstractGraph {

    // FIXME: scan path must use Set<edge> as path variable
    @Override
    public Path getPath(final String vertexAName, final String vertexBName) {
        Vertex vertexA = new Vertex(vertexAName);
        Vertex vertexB = new Vertex(vertexBName);

        Set<Edge> sourceVertexEdges = vertices.get(vertexA);
        if (sourceVertexEdges == null) {
            throw new GraphIntegrityException("vertex not exists");
        }

        Path currentPath = new Path();
        currentPath.add(vertexA);

        Queue<Path> pathsQueueToScan = new PriorityQueue<>();
        pathsQueueToScan.add(currentPath);

        while (true) {
            Path path = pathsQueueToScan.poll();
            if (path == null) {
                return null;
            }

            if (isTargetPath(path, vertexB)) {
                return path;
            }

            List<Path> nextPaths = scanPath(path);
            pathsQueueToScan.addAll(nextPaths);
        }
    }

    private List<Path> scanPath(Path path) {
        Vertex currentVertex = getLastVertex(path);
        Set<Edge> edges = vertices.get(currentVertex);

        List<Path> paths = new ArrayList<>();

        for (final Edge edge : edges) {
            Vertex nextVertex = edge.getVertexB();

            if (nextVertex.equals(currentVertex)) {
                continue;
            }

            if (path.contains(nextVertex)) {
                continue;
            }

            Path nextPath = new Path(path);
            nextPath.add(nextVertex);
            paths.add(nextPath);
        }

        return paths;
    }

    private boolean isTargetPath(final Set<Vertex> path, final Vertex targetVertex) {
        final Vertex currentVertex = getLastVertex(path);

        return currentVertex.equals(targetVertex);
    }

    private Vertex getLastVertex(final Set<Vertex> path) {
        return (Vertex) path.toArray()[path.size() - 1];
    }
}
