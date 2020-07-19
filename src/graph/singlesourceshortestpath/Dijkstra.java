package graph.singlesourceshortestpath;


import java.util.*;
import graph.utils.*;

public class Dijkstra
{
    Set<Integer> setX = new HashSet<>();
    Set<Integer> setV_X = new HashSet<>();
    Map<Integer, Integer> dijkstraScore = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> dijkstraScore.get(a)));

    public List<Integer> runDijkstra(int source, DirectedGraph graph){

        this.initialization(source, graph.getV());
        do{
            Integer vertex = pq.poll();
            List<Integer> children  = graph.getAdj().get(vertex);
            setX.add(vertex);
            setV_X.remove(vertex);
            for(int child: children){
                if(dijkstraScore.get(child)< dijkstraScore.get(vertex)+graph.getWeightMap().get(vertex+"-"+child)){
                    pq.remove(child);
                    int newScore = dijkstraScore.get(vertex)+graph.getWeightMap().get(vertex+"-"+child);
                    dijkstraScore.put(child, newScore);
                    pq.offer(child);
                }
            }

        }while(!pq.isEmpty());



        return null;
    }

    private void initialization(int source, int vertices){
        for(int i =0;i<vertices;i++){
            setV_X.add(i);
            if(i!=source){
                dijkstraScore.put(i,Integer.MAX_VALUE);
                pq.offer(i);
            }
        }
        dijkstraScore.put(source,0);
        pq.offer(source);

    }
}
