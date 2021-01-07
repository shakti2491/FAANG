package multithread.semaphore;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        MyBlockingQueue<String> myBlockingQueue = new MyBlockingQueue<>(2);


        final Runnable producer = ()-> {
            int count = 0;
          while(true){
              try
              {
                  myBlockingQueue.put(Thread.currentThread().getName()+"<-->"+createItem());
                  count++;

                  if(count==4)
                  {
                      Thread.sleep(50000);
                      count = 0;
                  }
              }
              catch (InterruptedException e)
              {
                  e.printStackTrace();
              }
          }
        };

        Thread producer1 =  new Thread(producer);
        Thread producer2 =  new Thread(producer);
        producer1.setName("producer1");
        producer2.setName("producer2");
        producer1.setDaemon(true);
        producer2.setDaemon(true);
        producer1.start();
        producer2.start();

        final Runnable consumer = () -> {
          while(true){
              try
              {
                  System.out.println(Thread.currentThread().getName()+"<-->"+myBlockingQueue.take());
              }
              catch (InterruptedException e)
              {
                  e.printStackTrace();
              }
          }
        };

        Thread consumer1 =  new Thread(consumer);
        Thread consumer2 =  new Thread(consumer);
        consumer1.setName("consumer1");
        consumer2.setName("consumer2");
        consumer1.setDaemon(true);
        consumer2.setDaemon(true);
        consumer1.start();
        consumer2.start();


        while (true){

        }
    }

    private  static Random random = new Random();
    private static String createItem(){
        return ""+random.nextInt(1000);
    }
    public static class MyBlockingQueue<T>{
        Semaphore full = new Semaphore(0);
        Semaphore empty ;
        private Queue<T> queue;
        private ReentrantLock lock = new ReentrantLock();

        public MyBlockingQueue(int capacity){
            if(capacity<1)
                throw new IllegalArgumentException();
            queue = new ArrayDeque<>(capacity);
            empty = new Semaphore(capacity);
        }

        public void put(T element) throws InterruptedException
        {
            empty.acquire();
            lock.lock();
            try{
                queue.offer(element);
            }
            finally
            {
                lock.unlock();
                full.release();
            }
        }

        public T take() throws InterruptedException
        {
            full.acquire();
            lock.lock();
            try{
                T element = queue.poll();
                return element;
            }
            finally
            {
                lock.unlock();
                empty.release();
            }
        }
    }
}
