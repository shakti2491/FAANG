package miscellanous;

import java.util.PriorityQueue;

public class Stone
{
    public static void main(String[] args)
    {
        int[] arr = { 31, 26, 33, 21, 40 };
        lastStoneWeightII(arr);
    }

    static int lastStoneWeightII(int[] stones) {
        // greedy first
        // use the heap
        if(stones.length == 1)
            return stones[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int stone : stones){
            pq.add(stone);
        }


        while(pq.size()>1){
            Integer currNum = pq.poll();
            Integer nextNum = pq.poll();

            int result = currNum-nextNum;
            if(result != 0)
                pq.add(result);

        }

        if(pq.size() == 0)
            return 0;

        return pq.poll();

    }
}
