package dp;

public class IntegerBreak
{

    public static void main(String[] args)
    {
        integerBreak(10);
    }

    static int integerBreak(int n) {
        int dp[] = new int[n+1];
        dp[1] = 0;
        dp[2] = 1;

        for(int i=3;i<=n;i++){

            dp[i] =1;
            for(int j =1; j<=i/2;j++){

                int result1 = j*(i-j);
                int result2 = Math.max(dp[j]*(i-j), result1);
                result1 = Math. max(result2, j*dp[i-j]);
                result2 = Math.max(result1, dp[j]*dp[i-j]);
                dp[i] = Math.max(dp[i],result2);

            }


        }
        return dp[n];

    }
}
