package miscellanous;

public class NumberOfDiceRollsSum
{
    public static void main(String[] args)
    {
        numRollsToTarget(1,6,3);

        Integer x =2;
        Integer z = 1;
    }

    static int numRollsToTarget(int d, int f, int target) {
        int n = target;
        int dp[][] = new int[d+1][n+1];

        for(int i =1;i<=f;i++){
            if(i<=n)
                dp[1][i] = 1;
        }

        for(int j =2;j<=d;j++){
            dp[j][1] = 0;
        }

        dp[1][1] = 1;


        for(int r= 2; r<= d; r++)
            for(int c= 1;c<=n;c++){


                for(int k =1; k<=f;k++){
                    if(c-k>=1)
                        dp[r][c] += dp[r-1][c-k];
                }

            }

        return dp[d][n];
    }
}
