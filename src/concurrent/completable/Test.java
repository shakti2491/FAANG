package concurrent.completable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test
{
    public static void main(String[] args)
    {
        ExecutorService executorService  = Executors.newFixedThreadPool(10);

        Deque<Integer> dq = new ArrayDeque<>(1);
        dq.offerFirst(1);
        dq.offerLast(2);
        System.out.println(dq.poll());
        String x ="a";

        int[][] arr1 = {{}};
        merge(arr1);
        System.out.println((arr1.length == 0||arr1[0].length ==0));
        System.out.println(x.substring(1));

        String[] arr = {"cat", "cats", "and", "sand", "dog"};
     wordBreak( "catsabca",  Arrays.asList(arr));
    }
    public static int[][] merge(int[][] intervals) {

        if(intervals.length ==0 || intervals[0].length==0)
            return new int[0][0];
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        int[] res = intervals[0];
        int start = res[0];
        int end = res[1];

        for(int i=1;i<intervals.length;i++){
            res = intervals[i];
            if(res[0]<=end){
                end = Math.max(end, res[1]);
            }
            else{
                result.add(new int[]{start, end});
                start = res[0];
                end = res[1];
            }

        }

        result.add(new int[] {start,end});


        return result.toArray(new int[result.size()][]);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> result = new ArrayList<>();
        List<String> sentence = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String w : wordDict){
            set.add(w);
        }
        helper(s, set, sentence, result);
        return sentence;

    }


         static void  helper(String post, Set<String> set, List<String> sentence, List<List<String>> sentences){
        if(post.equals("")){
            List<String> list = new ArrayList<>();
            list.addAll(sentence);
            sentences.add(list);
            return;
        }


        for(int end =1;end<=post.length();end++){
            String word = post.substring(0,end);
            if(set.contains(word)){
                sentence.add(word);
                helper(post.substring(end),set, sentence, sentences);
                sentence.remove(sentence.size()-1);
            }

        }

    }

}
class Order{
    public static void main(String[] args)
    {
        String date = "2020-07-31 02:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(date,formatter);
        System.out.println(LocalDate.now().atStartOfDay().isBefore(localDateTime));
    }

}

class getOrderTask implements Callable{
    @Override public Order call() throws Exception
    {
        return null;
    }
}

class enrichTask implements Callable{
    @Override public Order call() throws Exception
    {
        return null;
    }
}

class performPayment implements Callable{
    @Override public Order call() throws Exception
    {
        return null;
    }
}

class dispatchTask implements Callable{
    @Override public Order call() throws Exception
    {
        return null;
    }
}

class sendEmail implements Callable{
    @Override public Order call() throws Exception
    {
        return null;
    }
}
