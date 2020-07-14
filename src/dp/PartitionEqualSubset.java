package dp;

public class PartitionEqualSubset
{
    public static void main(String[] args)
    {
        int[] arr = new int[] {1, 2, 3, 5};
        System.out.println( helperDp(arr,11));
    }
  static   boolean helperDp(int nums[], int target){
      boolean dp[] = new boolean[target+1];
      dp[0] = true;


      for(int i=0;i<nums.length;i++){
          for(int j=target;j>=nums[i];j--){
              if(dp[j-nums[i]])
                  dp[j] = true;
          }
      }
      return dp[target];
    }
    static boolean canPartition(int[] nums) {
        // brute force
        // calculate total sum
        // find all the subsets
        // check if subset sum equals total -subset sum
        int total = 0;
        for(int num: nums){
            total += num;
        }

        if(total%2 !=0)
            return false;


        int target = total/2;


        return helper(nums,0, target, nums.length-1);

    }

    static boolean helper(int[] nums, int currSum , int target, int n){

        if(n<0)
            return false;

        if(currSum==target)
            return true;


        boolean a = helper(nums, currSum+nums[n], target,n-1);
        boolean b = helper(nums, currSum, target, n-1);
        if(a||b)
            return true;

        return false;


    }
}
