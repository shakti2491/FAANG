package graph.valid;

import java.util.ArrayList;

public class ValidGraph
{
   static ArrayList<Integer>[] graph;
    public static boolean validTree(int n, int[][] edges) {

        graph = new ArrayList[n];

        buildGraph(n,edges);

        int count =0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                if(count>1)
                    return false;
                if(dfsCycle(i,-1,visited))
                    return false;
            }

        }

        return true;

    }


    private static boolean dfsCycle(int node, int parent, boolean[] seen){
        seen[node] = true;
        ArrayList<Integer> children = graph[node];
        for(int i : children){

            if(!seen[i])
            {
                if (dfsCycle(i, node, seen))
                    return true;
            }

            else if(i!=parent)
                    return true;

        }

        return false;
    }

    private static void buildGraph(int n, int[][] edges){
        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

    }

    public static void main(String[] args)
    {
        int[][] arr = {{0,1}, {0,2}, {0,3}, {1,4}};
        validTree(5,arr);
    }

}
