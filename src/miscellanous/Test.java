package miscellanous;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Test
{
    public static void main(String[] args)
    {

        lengthOfLongestSubstring("abcabcbb");
    }
    static class Task implements Delayed{
        @Override public long getDelay(TimeUnit timeUnit)
        {
            return 0;
        }

        @Override public int compareTo(Delayed delayed)
        {
            return 0;
        }
    }
    // Function to print all the perfect
    // squares from the given range
    PriorityQueue<Pair<Character,Integer>> availablePool;
    Queue<Pair<Character, Integer>> waitPool;
    int N;
    public int leastInterval(char[] tasks, int n) {
        availablePool = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        // intially everything will be available
        // available pool with waiting period
        N = n;
        waitPool = new ArrayDeque<>(N+1);
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++)
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            availablePool.offer(new Pair<>(entry.getKey(),entry.getValue()));
        }
        int runTime = 0;
        while(!waitPool.isEmpty() || !availablePool.isEmpty()){

            Pair<Character,Integer> runTask = availablePool.poll();
            int count = runTask.getValue();

            if(count > 1){
                updateWaitPool(new Pair<>(runTask.getKey(), runTask.getValue()-1));
            }

            runTime++;
        }

        return runTime;
    }

    void updateWaitPool(Pair<Character,Integer> task){
        Pair<Character,Integer> pair = waitPool.poll();
        //waitPool.


}
    public static int lengthOfLongestSubstring(String s) {
        int[] index = new int[26];
        Arrays.fill(index,-1);
        char[] chars = s.toCharArray();
        int i =-1;
        int j = 0;
        int len = 1;
        while(j<chars.length){
            if(index[chars[j]-'a']!=-1){
                if(j-i>len)
                    len =j-i;
                if(i<index[chars[j]-'a'])
                    i = index[chars[j]-'a']+1;
            }
            index[chars[j]-'a'] = j;
            j++;
        }
        return len;
    }

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
