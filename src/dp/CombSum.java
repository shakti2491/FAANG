package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CombSum
{
    public static void main(String[] args)
    {
        comSum4(new int [] {1,2,3}, 4 );
    }

static int comSum4(int[] nums, int target){
    int len = nums.length;
    int[] dp = new int[target + 1];
    dp[0] = 1;

    // Find the minimum in the nums array.
    int min = IntStream.of(nums).min().orElse(0);
        if (min > target) return 0;
    dp[min] = 1;

        for (int i = min + 1; i <= target; i++){
    for (int n: nums){
        if (i - n >= 0){
            dp[i] += dp[i - n];
        }
    }
}
        return dp[target];
}
}
