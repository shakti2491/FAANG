package graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EventualSafeNodes
{
    public static void main(String[] args)
    {
        eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}});
    }

   static public List<Integer> eventualSafeNodes(int[][] graph) {
        // do a union find and find the cycle
        // place the edge which creats cycle in list
        // rest of the nodes are safe

        int n = graph.length;
        List<Integer> result = new ArrayList<>();
        Set<Integer> set  = IntStream.range(0,n).boxed().collect(Collectors.toSet());
        boolean [] visited = new boolean[n];
       boolean[] recursion = new boolean[n];


       for(int i=0; i<n;i++){

                if(dfs(set,graph,i,visited,recursion)){
                    result.add(i);
           }

        }
       System.out.println();
        return null;
    }
   static boolean dfs (Set<Integer> set,int[][] graph, int node, boolean visited[], boolean recursion[]){
        if(recursion[node]){
            return true;
        }

        recursion[node] = true;
        int[] children = graph[node];
        for(int child : children){

            if(dfs(set,graph, child,visited,recursion));
            return true;
        }

        recursion[node] = false;
        return false;
    }


}
