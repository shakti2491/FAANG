package graph.cycledetection.undirected;

import java.util.ArrayList;

public class DFSCycleDetection
{
    ArrayList<Integer> adjList[];
    private boolean dfsCycle(int node, int parent, boolean[] seen){
        seen[node] = true;
        for(int i : adjList[node]){

            if(!seen[i]){
                if(dfsCycle(i, node, seen))
                    return true;
            }
            else if(i!=parent)
                return true;

        }

        return false;
    }
}
