package miscellanous;

public class Test
{
    public static void main(String[] args)
    {
        reverseWords("the sjrf sfjssdf    fffsdfs");
        int[] arr = new int[3];
        method(arr);
        System.out.println(arr);
    }
    // Function to print all the perfect
    // squares from the given range

    public static String reverseWords(String s) {
        String[] words = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0;i++){
            words[i].trim();

            if(words[i].length()!=0){
                sb.append(words[i]);

            }

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
