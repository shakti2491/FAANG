package dp;

public class DiceSimulation
{
    class Solution {
        public int dieSimulator(int n, int[] rollMax) {
            long ans=0;
            int mod=(int)(1e9+7);
            long [][][] dp=new long[n][6][16];
            //Assume that when we roll the dice ith time, we get number j on it. The number j has now appeared count times "consecutively". Let dp[i][j][count] represent total number of such valid sequences


            //Initialize dp. On the first roll, we can get number 1 to 6, 1 times each. This will represent 1 valid sequence each. So initialze it to 1.

            for(int i=0;i<6;++i)
                dp[0][i][1]=1;

            //Go for every roll from 1 to n-1
            for(int i=1;i<n;++i){
                //Assume that the number appearing on dice on the ith roll is j
                for(int j=0;j<6;++j){
                    //Assume that the number appearing on dice on (i-1)th roll was j2
                    for(int j2=0;j2<6;++j2){
                        if(j2!=j){
                            //If the number does not repeat itself
                            for(int count=0;count<=rollMax[j2];++count,dp[i][j][1]%=mod)
                                dp[i][j][1]+=dp[i-1][j2][count];
                        }else{
                            //If the number repeats itself, then it might have occured any number of times from 2 to rollMax[j]
                            for(int count=2;count<=rollMax[j];++count){
                                dp[i][j][count]+=dp[i-1][j][count-1];
                                dp[i][j][count]%=mod; //% operator is distributive over addition. We have to modulo to ensure that the number does not overflows.
                            }
                        }
                    }
                }
            }

            //So, the answer will the the total number of valid sequeneces on the Nth roll. Again the number appearing on the Nth roll can be anything from 1 to 6. Also it might have occured 0 to rollMax[j] times. All these are valid and different sequences. So just add them up and you get the answer.
            for(int j=0;j<6;++j)
                for(int count=0;count<=rollMax[j];++count,ans%=mod)
                    ans+=dp[n-1][j][count];
            return (int)(ans);
        }
    }
}
