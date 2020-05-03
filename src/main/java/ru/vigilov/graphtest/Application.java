package ru.vigilov.graphtest;

import java.util.Collection;
import java.util.Scanner;

import ru.vigilov.graphtest.exceptions.GraphIntegrityException;
import ru.vigilov.graphtest.exceptions.VertexAlreadyExistsException;
import ru.vigilov.graphtest.graph.BaseGraph;
import ru.vigilov.graphtest.graph.DirectedGraph;
import ru.vigilov.graphtest.graph.UndirectedGraph;
import ru.vigilov.graphtest.graph.Vertex;

class Application {

    static Scanner userInput;

    public static void main(String[] args) {
        userInput = new Scanner(System.in);

        System.out.print("\n'Graph test java' console.");

        try {
            createGraphCommand();
        } finally {
            userInput.close();
        }
    }

    private static void createGraphCommand() {
        System.out.print("\nPlease, choose graph type\n");

        System.out.print("\n1. Undirected graph");
        System.out.print("\n2. Directed graph\n");

        System.out.print("\nType 1 or 2: \n");

        while (true) {
            String input = userInput.nextLine();
            switch (input) {
                case "1":
                    BaseGraph undirectedGraph = new UndirectedGraph();
                    chooseOperationCommand(undirectedGraph);
                    return;
                case "2":
                    BaseGraph directedGraph = new DirectedGraph();
                    chooseOperationCommand(directedGraph);
                    return;
                default:
                    System.out.println("\nPlease, type 1 or 2: \n");
            }
        }
    }

    private static void chooseOperationCommand(BaseGraph graph) {
        System.out.print("\nPlease, choose graph operation\n");

        System.out.print("\n1. Add vertex");
        System.out.print("\n2. Add edge");
        System.out.print("\n3. Get path\n");

        while (true) {
            String input = userInput.nextLine();
            switch (input) {
                case "1":
                    addVertexCommand(graph);
                    chooseOperationCommand(graph);
                    return;
                case "2":
                    addEdgeCommand(graph);
                    chooseOperationCommand(graph);
                    return;
                case "3":
                    getPathCommand(graph);
                    System.out.print("\nTo go to back step, please type 1 or type any other key to exit\n");
                    input = userInput.nextLine();

                    if ("1".equals(input)) {
                        chooseOperationCommand(graph);
                    }
                    return;
                default:
                    System.out.print("\nPlease, type 1 or 2: ");
            }
        }
    }

    private static void addVertexCommand(BaseGraph graph) {
        System.out.print("\n\nPlease, type vertex name");

        String input = userInput.nextLine();

        try {
            graph.addVertex(input);
        } catch (VertexAlreadyExistsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void addEdgeCommand(BaseGraph graph) {
        System.out.println("\n\nPlease, type vertex A name");

        String input = userInput.nextLine();

        String vertexAName = input;

        System.out.println("\n\nPlease, type vertex B name");

        input = userInput.nextLine();

        String vertexBName = input;

        try {
            graph.addEdge(vertexAName, vertexBName);
        } catch (GraphIntegrityException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void getPathCommand(BaseGraph graph) {
        System.out.println("\n\nPlease, type vertex A name");

        String input = userInput.nextLine();
        String vertexAName = input;

        System.out.println("\n\nPlease, type vertex B name");

        input = userInput.nextLine();
        String vertexBName = input;

        Collection<Vertex> path = graph.getPath(vertexAName, vertexBName);

        if (path == null) {
            System.out.print("\nPath: path is not exists");
            return;
        }

        System.out.printf("\nPath: %s", path.toString());
    }
}