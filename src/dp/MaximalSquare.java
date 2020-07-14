package dp;

public class MaximalSquare
{
    public static void main(String[] args)
    {
        char[][] arr = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] arr1 = {{'1','1'},{'1','1'}};
        System.out.println(arr1.length);
        System.out.println(arr1[0].length);
       maximalSquare(arr1);

    }
  static   public int maximalSquare(char[][] matrix) {
        if(matrix ==null || matrix.length ==0)
            return 0;

        if(matrix[0].length==0)
            return 0;


        int maxValue = 0;
        int[][] dp =new int[matrix.length][matrix[0].length];
        for(int i =0;i<matrix[0].length;i++){
            dp[0][i] = matrix[0][i]-'0';
            if(dp[0][i]>maxValue)
                maxValue = dp[0][i];
        }

        for(int i =0;i<matrix.length;i++){
            dp[i][0] = matrix[i][0]-'0';
            if(dp[i][0]>maxValue)
                maxValue = dp[i][0];
        }


        for(int i =1; i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    if(dp[i][j]>maxValue)
                        maxValue = dp[i][j];
                }

            }
        }
        return maxValue*maxValue;
    }
}
