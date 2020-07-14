package grokking.BitwiseXOR;

public class TwoSingleNumbers {

    public static int[] findSingleNumbers(int[] nums) {
        // TODO: Write your code here
        int n1xn2 = 0;
        for(int num : nums){
            n1xn2 ^=num;
        }

        int righmostSetBit = 1;
        while ((righmostSetBit&n1xn2)== 0){
            righmostSetBit =righmostSetBit <<1;
        }

        int num1 =0;
        int num2 =0;


        for(int num: nums){
            if((num & righmostSetBit)!=0)
                num1^=num;
            else
                num2^=num;
        }

        return new int[] { num1,num2 };
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        arr = new int[] { 2, 1, 3, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }
}
