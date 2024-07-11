package pe.edu.utp.aed.week16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Graph {
    private int vertices;
    private LinkedList<Edge>[] adjList;

    class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(dest, weight);
        adjList[src].add(edge);
    }

    void dijkstra(int src) {
        int[] dist = new int[vertices];
        boolean[] sptSet = new boolean[vertices];

        PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(edge -> edge.weight));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        pq.add(new Edge(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().dest;
            sptSet[u] = true;

            for (Edge edge : adjList[u]) {
                if (!sptSet[edge.dest] && dist[u] != Integer.MAX_VALUE && dist[u] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[u] + edge.weight;
                    pq.add(new Edge(edge.dest, dist[edge.dest]));
                }
            }
        }

        printSolution(dist);
    }

    void printSolution(int[] dist) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 3);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);

        graph.dijkstra(0);
    }
}

