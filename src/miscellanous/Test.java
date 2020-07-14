package miscellanous;

public class Test
{
    // Function to print all the perfect
    // squares from the given range
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
    public static void main(String[] args)
    {
       int[] arr = new int[3];
       method(arr);
        System.out.println(arr);
    }
   static void method(int[] arr){
        arr[0] = 1;
    }
}
