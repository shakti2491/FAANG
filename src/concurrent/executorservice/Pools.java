package concurrent.executorservice;

//Executor Service represents an asynchronous execution mechanism which is capable of executing tasks concurrently in background.

import java.util.List;
import java.util.concurrent.*;

// 1. FixedThreadPool
//2. CachedThreadPool
//3.ScheduledThreadPool
//4.SingleThreadExecutor
public class Pools
{

    static class CustomRejectionHandler implements RejectedExecutionHandler {
        @Override public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor)
        {

        }
    }
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService executorService = new ThreadPoolExecutor(10,100,120,TimeUnit.SECONDS, new ArrayBlockingQueue<>(300));



        try{
            executorService.execute(new Task());
        }catch (RejectedExecutionException ex){
            System.err.println("tsk rejected"+ex.getMessage());
        }
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.schedule(new Task(),10, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(new Task(),15,10,TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new Task(),15,10,TimeUnit.SECONDS);

        //initiate shutdown
        service.shutdown();

        // will throw rejection exception
        //service.execute(new Task());


        service.isShutdown();
        service.isTerminated();


        service.awaitTermination(10,TimeUnit.SECONDS);

        List<Runnable> runnableList = service.shutdownNow();

    }

    static  class Task implements Runnable{
        @Override public void run()
        {

        }
    }
}


