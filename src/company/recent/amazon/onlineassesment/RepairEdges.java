package company.recent.amazon.onlineassesment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class RepairEdges
{
   static int[] parent;

   static int repairEdges(int n, int[][] edges, int[][] repairs){

        //add
        parent = new int[n+1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        HashSet<String> set = new HashSet<>();
        for(int [] repairEdge : repairs){
            priorityQueue.offer(repairEdge);
            set.add(repairEdge[0]+"#"+repairEdge[1]);
        }


        for(int[] e: edges){
            String edge = e[0]+"#"+e[1];
            if(set.contains(edge)) continue;
            int[] ne = new int[] {e[0], e[1], 0};
            priorityQueue.add(ne);
        }

        Arrays.fill(parent,-1);

        int sum = 0;

        while (!priorityQueue.isEmpty()){
            int[] e = priorityQueue.poll();
            int u = e[0]; int v =e[1]; int w = e[2];
            int pu = find(u); int pv = find(v);
            if(pu!=pv){
                parent[pv] = pu;
                sum+=w;
            }

        }
       System.out.println("result-->>"+sum);
        return sum;
    }

    private static int find(int i){
        if(parent[i] == -1)
            return i;
        else
            return find(parent[i]);

    }

    public static void main(String[] args)
    {
        int n = 5;
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        int[][] edgesToRepair = {{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};
        repairEdges(n, edges, edgesToRepair);
    }
}
