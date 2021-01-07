package concurrent.executorservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ExecutorService1
{
    static AtomicInteger i = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newWorkStealingPool();
        //IO intensive large pool size
        // compute in

        List<Callable<String>> callables = Arrays.asList(
              callable("task1",2),
               callable("task2",1),
                callable("task3",3)
        );

        increment();
    }

    static Callable<String> callable(String result, long sleepSeconds){
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    static  void incr(){
        i.incrementAndGet();
    }
    static void increment(){
        ExecutorService es = Executors.newFixedThreadPool(2);
        IntStream.range(0,1000).forEach(i -> es.submit(() -> incr()));
        stop(es);
        System.out.println(i);
    }

    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }
}
