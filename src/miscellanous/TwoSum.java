package miscellanous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum
{

    public static void main(String[] args)
    {
         threeSum(new int[]{0,0,0});
    }

    static List<List<Integer>> threeSum(int[] nums) {
        //
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int first = nums[i];
            List<int[]> pairs = twoSum(nums,i+1,nums.length-1,-first);
            for(int[] pair : pairs){
                List<Integer> triplet = new ArrayList<>();
                triplet.add(first);
                triplet.add(pair[0]);
                triplet.add(pair[1]);
                result.add(triplet);
            }

        }
        return result;


    }
   static List<int[]> twoSum(int[] arr, int i, int j, int k){

        List<int[]> result = new ArrayList<>();

        while(i<j){
            if(arr[i]+arr[j]>k){
                j=j-1;

            }
            else if(arr[i]+arr[j]<k){
                i=i+1;
            }
            else{
                int [] pair = new int[]{arr[i],arr[j]};
                result.add(pair);
                while(i<j){
                    i =i+1;
                    j= j-1;
                    if(arr[i]!=arr[i-1] || arr[j]!=arr[j+1])
                        break;
                }
            }

        }

        return result;

    }
}
