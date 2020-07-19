package graph.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph
{
    private int V;   // No. of vertices
    private List<List<Integer>> adj;
    private Map<String, Integer> weightMap;

    // Constructor
    DirectedGraph(int v) {
        V = v;
        weightMap = new HashMap<>();
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(i, new ArrayList<>());
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void addEdge(int v, int w, int weight) {
        addEdge(v, w);
        weightMap.put(v + "-" + w, weight);

    }

    public int getV()
    {
        return V;
    }

    public List<List<Integer>> getAdj()
    {
        return adj;
    }

    public Map<String, Integer> getWeightMap()
    {
        return weightMap;
    }
}
