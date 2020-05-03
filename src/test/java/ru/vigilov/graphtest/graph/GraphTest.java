package ru.vigilov.graphtest.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    private BaseGraph directedGraph;

    private BaseGraph undirectedGraph;

    @Before
    public void setUp() {

        directedGraph = new DirectedGraph();

        directedGraph.addVertex("1");
        directedGraph.addVertex("2");
        directedGraph.addVertex("2.2");
        directedGraph.addVertex("2.3");
        directedGraph.addVertex("3");
        directedGraph.addVertex("3.1");
        directedGraph.addVertex("4");

        undirectedGraph = new UndirectedGraph();

        undirectedGraph.addVertex("1");
        undirectedGraph.addVertex("2");
        undirectedGraph.addVertex("2.2");
        undirectedGraph.addVertex("2.3");
        undirectedGraph.addVertex("3");
        undirectedGraph.addVertex("3.1");
        undirectedGraph.addVertex("4");
    }

    @Test
    public void testDirectedGraphGetPath() {

        directedGraph.addEdge("1", "2");
        directedGraph.addEdge("2", "2.2");
        directedGraph.addEdge("2.2", "2.3");
        directedGraph.addEdge("2.3", "3");
        directedGraph.addEdge("3", "4");

        Path path = directedGraph.getPath("1", "4");
        assertNotNull(path);

        path = directedGraph.getPath("4", "1");
        assertNull(path);
    }

    @Test
    public void testUndirectedGraph() {

        undirectedGraph.addEdge("1", "2");
        undirectedGraph.addEdge("2", "2.2");
        undirectedGraph.addEdge("2.2", "2.3");
        undirectedGraph.addEdge("2.3", "3");
        undirectedGraph.addEdge("3", "4");

        Path path = undirectedGraph.getPath("1", "4");
        assertNotNull(path);

        path = undirectedGraph.getPath("4", "1");
        assertNotNull(path);

        path = undirectedGraph.getPath("1", "3.1");
        assertNull(path);
    }
}
