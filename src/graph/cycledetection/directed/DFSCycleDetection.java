package graph.cycledetection.directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFSCycleDetection
{
}
class Graph
{

    private final int V;
    private final ArrayList<Integer>[] adj;

    public Graph(int V)
    {
        this.V = V;
        adj = new ArrayList[V];

        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();
    }

    public void addEdge(int source, int dest) {
        adj[source].add(dest);
    }
    }
