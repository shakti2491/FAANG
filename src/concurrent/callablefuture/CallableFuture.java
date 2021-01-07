package concurrent.callablefuture;

import java.util.concurrent.*;

public class CallableFuture
{
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Integer> future =executorService.submit(new Task());
        future.get(10, TimeUnit.SECONDS);
        // may interrupt if running
        future.cancel(false);
        future.isCancelled();
        future.isDone();
    }
}

class Task implements Callable<Integer>{
    @Override public Integer call() throws Exception
    {
        return null;
    }
}
