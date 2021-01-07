package multithread.deadlock;

import java.util.Random;

/**
 * Conditions of Deadlock

 *1. Mutual Exclusion
 *2. Hold and Wait
 *3. Non-preemptive allocation
 *4. Circular Wait
 *
 * Avoid anyone one of these condition to met to avoid deadlock
 */



public class DeadLock
{

    public static void main(String[] args)
    {
        Intersection intersection = new Intersection();
        Thread trainAThread = new Thread(new TrainA(intersection),"Train A");
        Thread trainBThread = new Thread (new TrainB(intersection)," Train B");

        trainAThread.start();
        trainBThread.start();
    }
    private static class TrainA implements Runnable{
        private Intersection intersection;
        private Random random = new Random();

        public TrainA(Intersection intersection)
        {
            this.intersection = intersection;
        }

        @Override public void run()
        {
            while (true){
                long sleepingTime = random.nextInt(10);
                try
                {
                    Thread.sleep(sleepingTime);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                this.intersection.takeRoadA();
            }
        }
    }
    private static class TrainB implements Runnable{
        private Intersection intersection;
        private Random random = new Random();

        public TrainB(Intersection intersection)
        {
            this.intersection = intersection;
        }

        @Override public void run()
        {
            while (true){
                long sleepingTime = random.nextInt(10);
                try
                {
                    Thread.sleep(sleepingTime);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                this.intersection.takeRoadB();
            }
        }
    }
    private static class Intersection
    {
        private Object roadA = new Object();
        private Object roadB = new Object();

        public void takeRoadA()
        {
            synchronized (roadA)
            {
                System.out.println("Road A is locked by  -->" + Thread.currentThread().getName());
                synchronized (roadB)
                {
                    System.out.println("Road B is locked by  -->" + Thread.currentThread().getName());
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e)
                    {

                    }
                }
            }
        }

        public void takeRoadB()
        {
            synchronized (roadB)
            {
                System.out.println("Road B is locked by  -->" + Thread.currentThread().getName());
                synchronized (roadA)
                {
                    System.out.println("Road A is locked by  -->" + Thread.currentThread().getName());

                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
