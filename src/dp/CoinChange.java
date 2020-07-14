package dp;

public class CoinChange
{
    static int coinChange(int[] coins, int amount) {
        int dp[] = new int [amount+1];
        for(int i =0;i<dp.length;i++){
            dp[i] = -1;
        }
        dp[0] = 0;

        for(int i=1; i<= amount;i++){
             int result = Integer.MAX_VALUE;
           for(int j : coins){
                   if (dp[i - j] != -1)
                       result = Math.min(result, 1 + dp[i - j]);
           }
           if(result!=Integer.MAX_VALUE)
           dp[i] = result;
        }



        return dp[amount];
    }

    public static void main(String[] args)
    {
        int[] arr = {2};
        System.out.println(coinChange(arr,3));
    }
}
