package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


// Java threads cannot be killed
// cooperative in nature

// using interrupts or volatile. atomic

public class ThreadTimeout
{

    Thread t1 = new Thread(()->{

        while ((!Thread.currentThread().isInterrupted())){
            // next step
        }

    });

    public static void main(String[] args)
    {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

      Future<?> future = threadPool.submit(()->{String a = "a"; return a;});



      threadPool.shutdownNow();
    }
}
