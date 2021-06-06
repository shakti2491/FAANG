package graph.cycledetection.directed;

import graph.utils.Graph;

import java.util.ArrayList;

public class DFSCycleDetection
{
    public boolean detectCycle(Graph graph){
        boolean[] visited = new boolean[graph.getVertices()];
        boolean[] recStack = new boolean[graph.getVertices()];

        for(int i =0; i<graph.getVertices();i++){
            if(!visited[i]){
                if(dfsCycleCheck(visited, recStack, i, graph))
                    return true;
            }
        }
        return false;
    }


    boolean dfsCycleCheck(boolean[] visited,boolean[] recStack, int currNode, Graph graph){
        if(recStack[currNode])
            return true;
        if(visited[currNode])
            return false;

        visited[currNode] = true;
        recStack[currNode] = true;
        ArrayList<Integer> children = graph.getAdj()[currNode];

        for(int i : children)
            if(dfsCycleCheck(visited,recStack,i,graph))
                return true;
        recStack[currNode] = false;
        return false;
    }


    public static void main( String args[] ) {

        try{
            throw new ArithmeticException();
        }catch(Exception e){
            throw new NullPointerException();
        }finally{
            throw new NumberFormatException();
        }
    }
}
