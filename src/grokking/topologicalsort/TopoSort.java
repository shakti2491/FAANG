package grokking.topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class TopoSort
{
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        // TODO: Write your code here
        List<Integer>[] graph = new ArrayList[vertices];
        for( int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

               List<Integer> children =  graph[u];
               if(children == null){
                   children = new ArrayList<>();
               }
               children.add(v);
               graph[u] = children;

        }

      Integer[] perm =  helperSort(vertices, graph);

        return sortedOrder;
    }

    private static Integer[] helperSort(int vertices, Object[] graph)
    {
        boolean visited[] = new boolean[vertices];
        Integer[] permutation = new Integer[vertices];
        int count = vertices-1;
        for(int i=0;i<vertices;i++)
        {
            if (!visited[i])
            {
                count = dfs(i, graph, count, permutation, visited);
            }
        }
return permutation;
        }



    private static int dfs(int node, Object[] graph, int count, Integer[] permutation, boolean[] visited)
    {
        visited[node] = true;
        List<Integer> children  = (List<Integer>) graph[node];
        if(children!= null)
        {
            for (int i = 0; i < children.size(); i++)
            {
                Integer child = children.get(i);
                if(!visited[i])
                count = dfs(child, graph, count, permutation, visited);
            }
        }
         permutation[count] = node;
        return count-1;
    }

    public static void main(String[] args) {
        TopoSort.sort(2, new int[][]{{1,0},{0,1}});

        List<Integer> result = TopoSort.sort(4,
        new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);
        result = TopoSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
        new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopoSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
        new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
        }

}
