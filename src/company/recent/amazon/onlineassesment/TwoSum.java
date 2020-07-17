package company.recent.amazon.onlineassesment;

import java.util.*;

public class TwoSum
{



    public static void main(String[] args) {
        int[] nums1 = {1, 10, 25, 35, 60};
        int target = 90;
    }
    static List<Integer> twoSum(List<Integer> arr, int target){
        List<Integer> result = Arrays.asList(-1,-1);
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.size();i++){
            int complement = target - arr.get(i);
            if((arr.get(i)>max || complement >max )&& map.containsKey(complement)){
                result.set(0, map.get(complement));
                result.set(1,i);
                max =Math.max(arr.get(i),complement);
            }
            map.put(arr.get(i),i);




        }

return result;

    }
}
