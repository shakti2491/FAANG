package dp;

import java.util.*;

public class StonesRemoved
{

    public static void main(String[] args)
    {
    int arr1 [][] = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
    int arr2 [][] = {{0,0},{0,2},{1,1},{2,0},{2,2}};
   // removeStones(arr2);
        int[][] edges = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        setup(6, edges);
    }

    static  int find(int[] parent, int i){
        if(parent[i] == -1)
            return i;
        else
            return find(parent, parent[i]);
    }

    static    void setup(int n , int[][] edges){

     int[] parent  = new int[n];
     for(int i =0; i<n;i++)
         parent[i] = -1;

     int extraEdge = 0;
     // performning union find to find the extra edges
     for(int[] edge : edges){
         int p1 = find(parent, edge[0]);
         int p2 = find(parent, edge[1]);
         if(p1==p2)
             extraEdge++;
         else
             parent[edge[1]] = p1;

     }


        Map<Integer, List<Integer>> graph = new HashMap<>();


        for(int i= 0;i<n;i++){

            graph.put(i, new ArrayList<>());
        }


        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

     int connectedComponents = 0;
     boolean[] visited = new boolean[n];
     for(int i=0;i <n;i++){
         if(!visited[i]){
             connectedComponents++;
             Stack<Integer> stack = new Stack<>();
             stack.push(i);
             visited[i] = true;
             while(!stack.isEmpty()){
                 Integer node = stack.pop();
                 List<Integer> child = graph.get(node);
                 for(int j=0; j<child.size();j++){
                     if(!visited[child.get(j)]){
                         visited[child.get(j)] = true;
                         stack.push(child.get(j));
                     }
                 }
             }

         }

     }
     System.out.println();
 }

    static int removeStones(int[][] stones) {
        // if the two entries of matrix have either common column or row than they have a edge

        // find number of connected components

        boolean[] visited = new boolean[stones.length];

        Arrays.sort(stones, (a,b) -> a[0]!=b[0]? a[0]-b[0]: a[1]-b[1]);

        int count = 0;
        for(int i = 0; i<stones.length;i++){
            if(!visited[i]){
                int nCount = 0;
                Set<Integer> set = new HashSet<>();
                set.add(stones[i][0]);
                set.add(stones[i][1]);
                visited[i] = true;
                for(int j= 0; j<stones.length; j++){
                    if(!visited[j])
                        if(set.contains(stones[i][0])|| set.contains(stones[i][1])){
                            set.add(stones[i][0]);
                            set.add(stones[i][1]);
                            visited[j] = true;
                            nCount++;
                        }


                }

                count +=nCount;
            }



        }




        return count;


    }
}
