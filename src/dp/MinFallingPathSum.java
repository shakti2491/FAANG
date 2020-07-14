package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**

 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 * A falling path starts at any element in the first row, and chooses one element from each row.
 * The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 */


public class MinFallingPathSum
{
    public static void main(String[] args)
    {
        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        minFallingPathSum(arr);
    }

    static int minFallingPathSum(int[][] A) {
      return   minFallingSumBruteForce(A);
    }


    // brute force
    // calculate all the falling paths(start a restricted dfs from different sources, row1)
    // find the min sum of them
  static   int minFallingSumBruteForce(int[][] A){

        int[][] visited = new int[A.length][A[0].length];
        int globalMinSum = Integer.MAX_VALUE;
        for(int i =0;i <A[0].length ;i++)
        {
            Integer minSum =   minFallingSumBruteForceHelper(A,0,i,0);
            if(minSum<globalMinSum)
                globalMinSum = minSum;
        }
        return globalMinSum;
    }

    private static int minFallingSumBruteForceHelper(int[][] A, int i,int j, int sum)
    {

        if(i>= A.length)
        {
           return sum;
        }
        else
        {
            int sum1 ,sum2 = Integer.MAX_VALUE,sum3 = Integer.MAX_VALUE;
            sum1 =    minFallingSumBruteForceHelper(A,i+1,j,sum + A[i][j]);
            if(j+1<A[0].length && j+1>=0)
            {
                sum2 = minFallingSumBruteForceHelper(A, i + 1, j + 1, sum + A[i][j + 1]);
            }
            if(j-1<A[0].length && j-1>=0)
              sum3 =  minFallingSumBruteForceHelper(A,i+1,j-1,sum + A[i][j-1]);

            return Math.min(sum3,Math.min(sum1,sum2));
        }
    }

}
