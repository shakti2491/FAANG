package concurrent.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue<T>
{
    private Queue<T> queue;
    private int max = 16;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();


    CustomBlockingQueue(int size){
        queue = new LinkedList<>();
        this.max = size;
    }
    private void put(T item) throws InterruptedException
    {
        lock.lock();
        try{
           while (queue.size() == max){
               // block the thread
               notFull.await();
           }

        queue.add(item);
        notEmpty.signalAll();
        }finally
        {
            lock.unlock();
        }

    }


    private T take() throws InterruptedException
    {
        lock.lock();
        try
        {
            while(queue.size()==0){
                // block the thread
                notEmpty.await();
            }
            T item = queue.remove();
            notFull.signalAll();
            return item;
        }finally
        {
            lock.unlock();
        }
    }
}
