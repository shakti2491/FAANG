package miscellanous;

import java.util.ArrayList;
import java.util.List;

public class Test
{
    public static void main(String[] args)
    {

        addBinary("111","1");
    }
    // Function to print all the perfect
    // squares from the given range
    public static String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        List<Character> result = new ArrayList<>();

        boolean carry = false;
        int i = a.length()-1;
        int j = b.length()-1;
        while(i>=0 && j>=0){
            char c;
            if(a.charAt(i) == '1' && b.charAt(j) == '1'){
                if(carry){
                    result.add(0,'1');

                }else{
                    result.add(0,'0');
                    carry = true;
                }

            }
            else if(a.charAt(i)=='0' && b.charAt(j)=='0'){
                if(carry){
                    result.add(0,'1');
                    carry =false;

                }else{
                    result.add(0,'0');
                }

            }
            else if(a.charAt(i)=='0'&& b.charAt(j)=='1'){
                if(carry){
                    result.add(0,'0');

                }else{
                    result.add(0,'1');
                }

            }
            else{
                if(carry){
                    result.add(0,'0');

                }else{
                    result.add(0,'1');

                }

            }
            i--;j--;

        }



        if(i>0){
            if(carry){
                if(a.charAt(i)=='0'){
                    result.add(0,'1');
                    carry =false;
                }else{
                    result.add(0,'0');
                    carry = true;
                }
            }else{
                result.add(0,a.charAt(i));
            }
        }


        if(j>0){
            if(carry){
                if(b.charAt(j)=='0'){
                    result.add(0,'1');
                    carry =false;
                }else{
                    result.add(0,'0');
                    carry = true;
                }
            }else{
                result.add(0,b.charAt(j));
            }
        }

        if(carry)
            result.add(0,'1');

        StringBuilder sb = new StringBuilder();
        for(int x =0;x<result.size();x++){
            sb.append(result.get(x));
        }
        return sb.toString();

    }
    static void perfectSquares(float l, float r)
    {

        int i =9;
        Long a = Long.MAX_VALUE;


        // Getting the very first number
        int number = (int) Math.ceil(Math.sqrt(l));

        // First number's square
        int n2 = number * number;

        // Next number is at the difference of
        number = (number * 2) + 1;

        // While the perfect squares
        // are from the range
        while ((n2 >= l && n2 <= r))
        {

            // Print the perfect square
            System.out.print(n2 + " ");

            // Get the next perfect square
            n2 = n2 + number;

            // Next odd number to be added
            number += 2;
        }
    }

    // Driver code

   static void method(int[] arr){
        arr[0] = 1;
    }
}
