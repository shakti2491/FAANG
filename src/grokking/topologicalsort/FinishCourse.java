package grokking.topologicalsort;

import java.util.*;

public class FinishCourse
{
    static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            int child = edge[0];
            int parent = edge[1];
            indegree[child]+=1;
            List<Integer> list = graph.get(parent);
            if(list ==null){
                list = new ArrayList<>();
                list.add(child);
                graph.put(parent,list);
            }
            else
                list.add(child);
        }

        // push all the elements to queue with zero indegrees
        Queue<Integer> queue = new ArrayDeque<>();
        for(int k=0;k<numCourses;k++){
            if(indegree[k]==0)
                queue.add(k);
        }
        int count =0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            List<Integer> list = graph.get(node);
            for(int x : list){
                indegree[x]+=-1;
                if(indegree[x]==0)
                    queue.add(x);
            }

        }


        if(count!=numCourses)
            return false;

        return true;
    }

    public static void main(String[] args)
    {
        canFinish(2, new int[][]{{1,0}});
    }
}
