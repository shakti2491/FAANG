package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle
{

    public static void main(String[] args)
    {

        List<List<Integer>> list  = new ArrayList<>();
        Integer arr[] = {2};
        list.add(Arrays.asList(arr));
        Integer arr1[] = {3,4};
        list.add(Arrays.asList(arr1));
        Integer arr2[] = {6,5,7};
        list.add(Arrays.asList(arr2));
        Integer arr3[] = {4,1,8,3};
        list.add(Arrays.asList(arr3));

        minimumTotal(list);
    }

    static int minimumTotal(List<List<Integer>> triangle) {
        // recursive
        // dp[i][j] is the maximum path length til j th element of ith row
        // dp[i][j] = max { dp[i-1][j-1] + dp[i-1][j]} + val[i][j]

        int lastSize = triangle.get(triangle.size()-1).size();
        int dp[] = new int[lastSize];
        dp[0] = triangle.get(0).get(0);
        for(int i =1; i<triangle.size();i++){
            int[] dp2= new int[lastSize];
            List<Integer> row = triangle.get(i);
            for(int j =0; j<row.size();j++){
                if(j==0)
                    dp2[j] = dp[j] + row.get(j);
                else if(j== row.size()-1)
                    dp2[j] = dp[j-1] + row.get(j);
                else
                    dp2[j] = Math.min(dp[j-1], dp[j])+row.get(j);


            }
            dp = dp2;
        }

        int result = Integer.MAX_VALUE;
        for(int i =0; i<lastSize; i++){
            result = Math.min(dp[i], result);
        }

        return result;
    }
}
