package dp;

import java.util.Arrays;

public class PartitionSubset
{
    public static void main(String[] args)
    {
        canPartition(new int[] {1, 2});
    }


  static   boolean flag = false;
  static   public boolean canPartition(int[] nums) {
        // sub two sums denote

        helper(nums,0,0,0);

        return flag;


    }


  static   void helper(int[] nums, int s1, int s2, int index){

        // base case

        if(index == nums.length)
        {
             if (s1 == s2)
            {
                flag = true;
            }
        }
        else
            {
                for (int i = index; i < nums.length; i++)
                {
                    helper(nums, s1 + nums[i], s2, index + 1);
                    helper(nums, s1, s2 + nums[i], index + 1);

                }
            }
    }


    static boolean canPartition1(int[] nums) {
        if(nums.length < 2)
            return false;
        int sum = 0;
        for(int num: nums)
            sum += num;
        if(sum % 2 != 0)
            return false;
        int target = sum / 2;
        //Sort nums
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 0; i--) {
            //because nums is already sorted, if target - nums[i] < 0 , the rest of target - nums[] will be < 0
            if(target - nums[i] < 0)
                return false;
            if(dfs(nums, i, target, 0))
                return true;
        }
        return false;
    }
   static boolean dfs(int[] nums, int start, int target, int count) {
        if(target == 0 && count < nums.length)
            return true;
        for(int i = start; i >= 0; i--) {
            if(target - nums[i] < 0)
                return false;
            if(dfs(nums, i - 1, target - nums[i], count + 1))
                return true;
        }
        return false;
    }
}
