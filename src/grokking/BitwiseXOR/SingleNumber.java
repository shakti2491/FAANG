package grokking.BitwiseXOR;

public class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        // TODO: Write your code here

        if(arr==null || arr.length ==0)
            return -1;

        int num = arr[0];
        for(int i=1; i<arr.length;i++)
            num = num^arr[i];
        return num;
    }

    public static void main( String args[] ) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}
