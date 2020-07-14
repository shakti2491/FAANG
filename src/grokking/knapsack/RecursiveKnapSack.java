package grokking.knapsack;

public class RecursiveKnapSack
{
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return this.knapsackRecursive(dp,profits, weights, capacity, 0);
    }

    private int knapsackRecursive(Integer[][] dp,int[] profits, int[] weights, int capacity, int index)
    {
        if(capacity<=0 || index >= profits.length)
            return 0;

        if(dp[index][capacity] != null)
            return dp[index][capacity];
        int profit1 =0;
        if(weights[index]<=capacity)
         profit1 =
                profits[index] +
                        knapsackRecursive(dp,profits, weights, capacity-weights[index], index+1);
        int profit2 = knapsackRecursive(dp,profits, weights, capacity, index+1);

        dp[index][capacity] = Math.max(profit1, profit2);
        return Math.max(profit1, profit2);

    }
    public static void main(String[] args) {
        RecursiveKnapSack ks = new RecursiveKnapSack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
