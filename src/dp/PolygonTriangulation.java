package dp;

public class PolygonTriangulation
{
    public static void main(String[] args)
    {
        minScoreTriangulation(new int[]{1,2,3});
    }
    static int minScoreTriangulation(int[] A) {
        // divide problem into two subproblems
        // for every partition
        // calculate sum and minimum

        int len = A.length;
        Integer [][] dp = new Integer[len][len];
        return helper(A, 0 , len-1, dp);

    }


 static    int helper(int[] A, int i, int j, Integer[][] dp){
        if(j-i<=1)
            return 0;
        if(dp[i][j]!=null)
            return dp[i][j];
        dp[i][j] =Integer.MAX_VALUE;
        for(int k =i+1;k<j;k++){

            int triangle = A[i]*A[j]*A[k];
            dp[i][j] = Math.min(dp[i][j], helper(A,i,k, dp)+helper(A,k,j,dp)*triangle);
        }
        return dp[i][j];
    }
}
