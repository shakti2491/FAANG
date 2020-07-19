package graph.utils;

import java.util.ArrayList;

public class Graph
{



    private final int vertices;
    private final ArrayList<Integer>[] adj;

    public Graph(int vertices)
    {
        this.vertices = vertices;
        adj = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++)
            adj[i] = new ArrayList<>();
    }

    public void addEdge(int source, int dest) {
        adj[source].add(dest);
    }

    public int getVertices()
    {
        return vertices;
    }

    public ArrayList<Integer>[] getAdj()
    {
        return adj;
    }
}
