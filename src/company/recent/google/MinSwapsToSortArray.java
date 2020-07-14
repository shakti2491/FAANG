package company.recent.google;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinSwapsToSortArray
{

    // 7 2 1 5 4 3
    // find the position of each number
    //O(n2) time complexity

    // We will have n nodes and an edge directed from node i to node j
    // if the element at i’th index must be present at j’th index in the sorted array.

    public int minSwaps(int[] nums){

        // create a array of pairs in which one key is the number and value is the originbal
        // index position

        int n = nums.length;
        List<Pair<Integer, Integer>> sortedList = new ArrayList<>();

        for(int i =0; i<n;i++){
            Pair<Integer, Integer> pair = new Pair<>(nums[i], i);
            sortedList.add(pair);
        }
        sortedList.stream().sorted(Comparator.comparingInt(Pair::getKey));

        int result = 0;
        boolean visited[] = new boolean[n];
        for(int i =0; i<n;i++){
            // already swapped or corrected
            if(visited[i] || sortedList.get(i).getValue() == i)
                continue;

            int j = i;
            int cycle = 0;
            while(!visited[j]){
                visited[j] = true;
                cycle++;
                j = sortedList.get(j).getValue();
            }
            if(cycle>0){
                result+=cycle-1;
            }
        }
return result;
    }
}
