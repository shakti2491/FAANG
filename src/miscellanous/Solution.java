package miscellanous;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Solution {

    Solution(int a){
        if(a==0)
            return;
        System.out.println("jhaf");
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution(0);
String str = "adsas";

List<String> list = new ArrayList<>(Arrays.asList("asdsd","afasdasf"));

Integer.toBinaryString(12).length();
Optional<String> test = list.stream().collect(Collectors.reducing((a,b)->null));

int[][] mat = {{-2,-3,3},{-5,-10,1},{10,30,-5}};

solution.calculateMinimumHP(mat);
    }


    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] matrix = dungeon;
        int[][] dp = new int[m][n];

        int[][] min = new int[m][n];
        min[0][0] = matrix[0][0];
        dp[0][0] = matrix[0][0];

        dp[0][0]=matrix[0][0];
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + matrix[i][0];
            min[i][0] = Math.min(min[i-1][0],dp[i][0]);

        }
        for(int i =1;i<n;i++){
            dp[0][i] = dp[0][i-1] + matrix[0][i];
            min[0][i] = Math.min(min[0][i-1], dp[0][i]);
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int T = dp[i-1][j]+matrix[i][j];
                int R = dp[i][j-1]+matrix[i][j];
                int minT = min[i-1][j];
                int minR = min[i][j-1];


                int A = Math.min(T,minT);
                int B = Math.min(R,minR);


                if(A>B){
                    dp[i][j] = T;
                    min[i][j] = Math.min(T,minT);
                }else{
                    dp[i][j] = R;
                    min[i][j] = Math.min(R,minR);
                }
            }

        }
        return (min[m-1][n-1]);
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {

        int m = mat.length, n= mat[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = mat[0][0];
        for(int i=1;i<n;i++)
            dp[0][i] = dp[0][i-1]+mat[0][i];
        for(int i =1;i<m;i++)
            dp[i][0] = dp[i-1][0]+mat[i][0];


        // calculate prefix sum for matrix
        for(int i =1; i<m;i++)
            for(int j =1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[j-1][i]-dp[i-1][j-1]+mat[i][j];
            }
        for(int i = 1; i <m; i++ ){
            for(int j = 1; j<n ; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1] - dp[i-1][j-1] + mat[i][j];
            }
        }
        // calcute block sum
        int rmin,rmax,cmin,cmax;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                rmin = i -K -1;
                rmax = Math.min(m-1,i + K);
                cmin = j - K-1;
                cmax = Math.min(n-1,j + K);

                mat[i][j] = dp[rmax][cmax];
                if(rmin>=0 &&cmin >=0) mat[i][j] += dp[rmin][cmin];
                if(rmin >=0) mat[i][j] -= dp[rmin][cmax];
                if(cmin >=0) mat[i][j] -= dp[rmax][cmin];


            }
        }
        return mat;
    }
    private String intLenToByteArray(String s){
        int len = s.length();

        byte[] bytes = new byte[] {
                (byte)((len >>24) & 0xff),
                (byte)((len>>16) & 0xff),
                (byte)((len>>8)& 0xff),
                (byte)((len) & 0xff)
        };
        return new String(bytes);
    }

    public String intToString2(String s){
       byte[] bytes =  ByteBuffer.allocate(4).putInt(s.length()).array();
       return new String(bytes);
    }
    public String intToString(String s) {
        int x = s.length();
        char[] bytes = new char[4];
        for(int i = 3; i > -1; --i) {
            bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
        }
        return new String(bytes);
    }
    public int[] searchRange(int[] nums, int target) {

        int index1 = findFirst(nums,target);
        int index2 = findLast(nums, target);

        return new int[] {index1, index2};

    }


    int findFirst(int[] arr, int k){

        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start <= end ){
            int mid = start +((end-start)/2);
            if(arr[mid]>= k){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }

        }
        if(ans!=-1){
            if(arr[ans]!=k)
                ans =-1;
        }

        return ans;

    }

    int findLast(int[] arr, int k ){

        int start = 0;
        int end = arr.length-1;
        int ans =-1;
        while(start <=end){
            int mid = start+(end-start)/2;

            if(arr[mid]<=k){
                ans =mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }

        }
        if(ans!=-1){
            if(arr[ans]!=k)
                ans = -1;
        }

        return ans;
    }


    int maxHr = -1;
    int maxMin = -1;
    public String largestTimeFromDigits(int[] A) {

        List<String> arr = new ArrayList<>();
        for(int i: A)
            arr.add(""+i);

        helper(arr,new ArrayList<>());

        if(maxHr!=-1 && maxMin!=-1){

            return maxHr/10+""+maxHr%10+":"+maxMin/10+""+maxMin%10;

        }

        return "";

    }


    void helper(List<String> arr, List<String> time){
        if(arr.size()==0){
            time.forEach(System.out :: print);
            System.out.println();




            return;
        }


        for(int i = 0; i<arr.size();i++){

            String num = arr.get(i);
            time.add(num);
            arr.remove(num);
            helper(arr, time);
            arr.add(i,num);
            time.remove(num);

        }

    }

    boolean isValid(int hr, int min){
        if(hr<24 && min <60)
            return true;

        return false;
    }



    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n<s.length())
            return false;
        if(n==2) return s.charAt(0) ==s.charAt(1);


        for(int i =1; i<(int)Math.sqrt(n);i++){

            if(n%i == 0){
                List<Integer> divisors = new ArrayList<>();
                divisors.add(i);
                if(i!=1){
                    divisors.add(n/i);
                }



                for(int l : divisors){


                    String pattern = s.substring(0,l);
                    int hash1 = pattern.hashCode();
                    int j = l;
                    for(; j<n;j=j+l){
                        String str = s.substring(j,j+l);

                        int hash =str.hashCode();
                        if(hash != hash1)
                            break;
                    }

                    if(j==n)
                        return true;
                }

            }

        }

        return false;
    }

}
