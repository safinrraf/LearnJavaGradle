package com.learn.classic;

/**
 * <a href="">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code ..., ..., ...}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 ...}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 30.11.24 16:39
 */
import java.util.*;

public final class EulerianCircuit {

    static class Graph {
        private int vertices;
        private LinkedList<Integer>[] adj;

        // Constructor for the graph
        Graph(int vertices) {
            this.vertices = vertices;
            adj = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        // Add an edge to the graph
        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u); // Since the graph is undirected
        }

        // Remove an edge from the graph
        void removeEdge(int u, int v) {
            adj[u].remove((Integer) v);
            adj[v].remove((Integer) u);
        }

        // Perform DFS to check connectivity
        private void dfs(int v, boolean[] visited) {
            visited[v] = true;
            for (int neighbor : adj[v]) {
                if (!visited[neighbor]) {
                    dfs(neighbor, visited);
                }
            }
        }

        // Check if the graph is still connected after removing an edge
        private boolean isConnected() {
            boolean[] visited = new boolean[vertices];

            // Find a vertex with a non-zero degree
            int startVertex = -1;
            for (int i = 0; i < vertices; i++) {
                if (adj[i].size() > 0) {
                    startVertex = i;
                    break;
                }
            }

            // If there are no edges in the graph, it's connected
            if (startVertex == -1) {
                return true;
            }

            // Start DFS from the first non-zero degree vertex
            dfs(startVertex, visited);

            // Check if all vertices with non-zero degree are visited
            for (int i = 0; i < vertices; i++) {
                if (adj[i].size() > 0 && !visited[i]) {
                    return false;
                }
            }
            return true;
        }

        // Check if the edge u-v is a valid next edge
        private boolean isValidNextEdge(int u, int v) {
            // If there's only one edge, it's valid
            if (adj[u].size() == 1) {
                return true;
            }

            // Otherwise, check if it's a bridge
            // Remove edge u-v and check connectivity
            removeEdge(u, v);
            boolean isConnectedAfterRemoval = isConnected();
            addEdge(u, v); // Re-add the edge to restore the graph

            return isConnectedAfterRemoval;
        }

        // Print the Eulerian Circuit
        void printEulerianCircuit() {
            // Find a vertex with a non-zero degree to start
            int startVertex = 0;
            for (int i = 0; i < vertices; i++) {
                if (adj[i].size() > 0) {
                    startVertex = i;
                    break;
                }
            }

            System.out.println("Eulerian Circuit:");
            dfsEulerian(startVertex);
        }

        // Perform DFS to print Eulerian Circuit
        private void dfsEulerian(int u) {
            for (int v : new ArrayList<>(adj[u])) {
                if (isValidNextEdge(u, v)) {
                    System.out.print(u + " -> ");
                    removeEdge(u, v);
                    dfsEulerian(v);
                }
            }
            System.out.print(u); // Print the last vertex in the circuit
        }

        // Check if the graph has an Eulerian Circuit
        boolean hasEulerianCircuit() {
            // Check if all vertices have even degree
            for (int i = 0; i < vertices; i++) {
                if (adj[i].size() % 2 != 0) {
                    return false;
                }
            }
            // Check if the graph is connected
            return isConnected();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        // Example: Add edges to create an Eulerian Circuit
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(0, 4);
        graph.addEdge(4, 3);

        if (graph.hasEulerianCircuit()) {
            graph.printEulerianCircuit();
        } else {
            System.out.println("The graph does not have an Eulerian Circuit.");
        }
    }
}

