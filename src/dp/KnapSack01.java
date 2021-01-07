package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnapSack01
{

    public static void main(String[] args)
    {
        int arr[][] = new int[][] {{3,4},{2,3},{4,2},{4,3}};
        helper2(new int[]{1,2},1);
        knapSack(arr,6);
    }
  static   int knapSack(int[][] arr, int w)
    {
        // weight of the sack
        // arr array has weight and profit of each item

        // dp[i][x] is the maximum profit after consuming i elements and having weight less than or equal to x

        int[]dp = new int[w + 1];

        for (int i = 0; i < arr.length; i++)
        {
//            int[] dp2 = new int[w+1];
            for (int j = w; j >= 1; j--)
            {
                if (j >= arr[i][1])
                    dp[j] = Math.max(dp[j], dp[j - arr[i][1]] + arr[i][0]);

            }
            //dp= dp2;
            System.out.println();
        }
        return dp[w];
    }



   static int helper2(int[] arr, int capacity){
        int dp[][] = new int[arr.length+1][capacity+1];

       int max = 0;
       for(int i=0;i<arr.length;i++){
           for(int j =arr[i];j<=capacity;j++){
               dp[i+1][j] = Math.max(dp[i][j], arr[i]+dp[i][j-arr[i]]);
               if(dp[i+1][j]>max)
                   max = dp[i+1][j];
           }
       }

       return max;
    }

 static    void test(){

        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int n = 15;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }


        for(int i=0;i<manager.length;i++){
            if(manager[i]!=-1){
                List<Integer> child = map.get(manager[i]);
                child.add(i);
            }
        }

    }
}
