package graph.cycledetection.directed;

import graph.utils.Graph;

import java.util.*;

public class TopoSortCycleDetection
{

    boolean detectCycle(Graph g){
        Map<Integer, Integer> inDeg = new HashMap<>();


        for(int i=0;i<g.getVertices();i++)
        {
            List<Integer> children = g.getAdj()[i];
            for (int child : children)
                inDeg.put(child, inDeg.getOrDefault(child, 0) + 1);
        }
            Queue<Integer> q = new ArrayDeque<>();
            for(int i=0;i<g.getVertices();i++){
                if(inDeg.get(i)==null){
                    q.offer(i);
                }
            }

         int count = 0;


         List<Integer> order = new ArrayList<>();


         while(!q.isEmpty()){
             int len = q.size();
             for(int j=0;j<len;j++){
                 Integer node = q.poll();
                 order.add(node);
                 count++;
                 List<Integer> children  = g.getAdj()[node];
                 for(int child: children){
                  inDeg.put(child, inDeg.get(child)-1);

                  if(inDeg.get(child) ==0)
                      q.offer(child);
                 }
             }
         }

         if(count == g.getVertices())
             return false;
        return true;
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

        System.out.println(new TopoSortCycleDetection().detectCycle(graph));
    }
}
