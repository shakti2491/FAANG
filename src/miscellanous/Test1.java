package miscellanous;

import utils.TreeNode;

import java.util.*;

public class Test1
{
    public static void main(String[] args)
    {
        String[] sttrs= new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Arrays.sort(sttrs);
        int x =-1 ;
        System.out.println(x>>>1);
        partitionLabels("ababcbacadefegdehijhkli");

// topKFrequent(new int[]{1,1,1,2,2,3},2);

      //  hammingDistance(1,4);
        // minPathSumHelper2(new int[][] {{1,2,5},{3,2,1}});
        //System.out.println(findIndex(new int[]{8,5,1,7,10,12}, 5,false));
    }

    String str = "";
    public String tree2str(TreeNode t) {
        tree2strHelper(t);
        return str.substring(1,str.length()-1);
    }


    void tree2strHelper(TreeNode t){
        if(t==null)
            return;

        str = str + "(" +t.val;

        if(t.left == null && t.right!=null)
        {
            str = str + "()";
            tree2strHelper(t.right);
        }

        else{
            tree2strHelper(t.left);
            tree2strHelper(t.right,str);
        }


        str = str + ")";

    }
    public static List<Integer> partitionLabels(String S) {
        char[] chars = S.toCharArray();
        int[] dp = new int[chars.length];
        int[] hash = new int[26];
        Arrays.fill(hash,-1);
        hash[chars[0]-'a'] = 0;
        dp[0] = 1;
        for(int i=1;i<chars.length;i++){
            if(hash[chars[i]-'a'] ==-1){
                dp[i] = dp[i-1]+1;
                hash[chars[i]-'a'] = i;
            }
            else
            {
                int minIndex = findMin(hash[chars[i]-'a'],i,dp);
                dp[i] = dp[minIndex];
                hash[chars[i]-'a'] = i;

            }


        }

        for(int k =dp.length-1; k>=0;k--){
            int i = k;
            

        }

        return null;

    }

  static   int  findMin(int i, int j, int[] dp){
        int min = i;
        for(int k=i; k<j;k++){

            if(dp[k]<dp[min])
                min = k;


        }

        return min;

    }


    static int[] topKFrequent(int[] nums, int k)
    {
        if (nums == null || nums.length == 0)
            return new int[] {};

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);

        int[] result = new int[count.size()];

        return result;
    }



    private static int findIndex(int[] arr, int i, boolean min){
        if(min){
            i++;

            if(i<arr.length && arr[i-1]>arr[i])
                return i;


        }
        else{
            int j=i;
            j++;
            while(j<arr.length){
                if(arr[j]> arr[i])
                    return j;

                j++;
            }
        }

        return -1;
    }


    static int hammingDistance(int x, int y) {
        // do a xor operation and count

        int x_y = x^y;
        int count =0;
        for(int i=1;i<=31;i++){
            int and = x_y&1;
            if(and == 1)
                count++;
            x_y = x_y>>1;
        }
        return count;

    }
    static Exception print(int i){

            throw new RuntimeException();
    }

  static   int minPathSumHelper2(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for(int j=1;j<m;j++){
            dp[j][0]= dp[j-1][0] + grid[j][0];
        }

        for(int i = 1;i<m;i++){
            for(int j =1;j<m;j++){
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j])+grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }

}
