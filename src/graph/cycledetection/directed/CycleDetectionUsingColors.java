package graph.cycledetection.directed;

import graph.utils.Graph;

import java.util.List;

public class CycleDetectionUsingColors
{
    boolean detectCycle (Graph graph){
        int[] color = new int[graph.getVertices()];
        for(int  i=0; i<graph.getVertices();i++){
            color[i] = 0;
        }

        for(int i=0;i<graph.getVertices();i++){
            if(color[i] == 0){
                if(dfsCheck(color, i, graph))
                    return true;
            }
        }

        return false;
    }

    boolean dfsCheck(int[] color, int u, Graph graph){
        color[u] = 1;
        List<Integer> children = graph.getAdj()[u];
        for(int child : children){
            if(color[child] == 1)
                return true;
            if(color[child] == 0)
                if(dfsCheck(color,child,graph))
                    return true;

        }

        color[u] = 2;
        return false;



    }

    public static void main(String[] args)
    {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println(new CycleDetectionUsingColors().detectCycle(graph));
    }
}
