package graph.toposort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TopoSortBFSDFS
{
    ArrayList<Integer>[] adjList;
    int[] order;
    int[] inDeg;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // check cycle first
        adjList = new ArrayList[numCourses];
        order = new int[numCourses];
        inDeg = new int[numCourses];
        buildGraph(prerequisites);
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDeg[i]==0)
                q.add(i);
        }

        int i =0;
        while(!q.isEmpty()){
            int vertex = q.poll();
            order[i++] = vertex;
            for(int child: adjList[vertex]){
                    inDeg[child]--;
                    if(inDeg[child]==0)
                        q.offer(child);

            }
        }

        if(i<numCourses)
            return new int[0];


        return order;
    }


    private void dfs(boolean[] visited,ArrayList<Integer>[] graph, int cur){
        visited[cur] = true;
        for(int child : graph[cur]){
            if(!visited[child])
                dfs(visited, graph, child);
        }
    }


    // build graph
    private void buildGraph(int[][] pre){
        for(int i=0; i<adjList.length;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : pre){
            int v = edge[0];
            int u = edge[1];
            adjList[u].add(v);
            inDeg[v]++;
        }
    }
}
