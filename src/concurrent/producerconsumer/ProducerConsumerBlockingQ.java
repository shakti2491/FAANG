package concurrent.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQ
{
    public static void main(String[] args)
    {
        BlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<>(10);

        final Runnable producer = ()->{
            while (true){
                try
                {
                    blockingDeque.put(createItem());
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };

        final Runnable consumer = () -> {
            while (true){
                try
                {
                    Integer i = blockingDeque.take();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(consumer).start();
        new Thread(consumer).start();

    }

    private static Integer createItem(){
        return -1;
    }
}
