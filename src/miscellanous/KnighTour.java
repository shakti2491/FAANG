package miscellanous;

public class KnighTour
{
    public static void main(String[] args)
    {
        knightProbability(3,2,0,0);
    }


    static double knightProbability(int N, int K, int r, int c) {
        int[] dr = {-2,-2,1,1,-1,-1,2,2};
        int[] dc = {-1,1,-2,2,-2,2,-1,1};
        // 2-d array to reprensent cuurent state of the knigh
        double dp[][] = new double[N][N];
        dp[0][0] = 1.0;
        // for each step we will have new 2- array which will use old dp


        for(int k = 0 ;k<K;k++){
            double[][] dp2 = new double[N][N];

            for(int i =0; i<N;i++){
                for(int j =0; j<N ; j++){
                    System.out.println();
                    for(int x = 0; x<8;x++){
                        if(0<=i+dr[x] && i+dr[x]<N && 0<=j+dc[x] &&j+dc[x]<N )
                            dp2[i][j] += dp[i+dr[x]][j+dc[x]];
                    }
                    dp2[i][j] = dp2[i][j]/8;
                }

            }
            dp=dp2;

        }
        double result = 0.0;
        for(double [] d1 : dp){
            for(double d2 : d1)
                result += d2;
        }
        return result;
    }

}
