package multithread.criticalsection;

import java.util.Random;

public class Atomic
{
    public static void main(String[] args)
    {
        Metrics metrics = new Metrics();
        BusinessLogic businessLogicThread1 = new BusinessLogic(metrics);
        BusinessLogic businessLogicThread2 = new BusinessLogic(metrics);
        MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);
        businessLogicThread1.start();
        businessLogicThread2.start();
        metricsPrinter.start();


    }

    private static class MetricsPrinter extends Thread{
        private Metrics metrics;
        public MetricsPrinter(Metrics metrics){
            this.metrics = metrics;
        }

        @Override public void run()
        {
            while(true){
                double currentAverage = metrics.getAverage();
                System.out.println("Current Average is "+ currentAverage);
            }
        }
    }
    private static class BusinessLogic extends Thread{
        private Metrics metrics;
        private Random random = new Random();

        public BusinessLogic(Metrics metrics){
            this.metrics = metrics;
        }

        @Override public void run()
        {
            while(true)
            {
                long start = System.currentTimeMillis();
                try
                {
                    Thread.sleep(random.nextInt(10));
                }
                catch (InterruptedException ex)
                {

                }
                long end = System.currentTimeMillis();
                metrics.addSample(end - start);
            }
        }
    }

    private static class Metrics{
        private volatile long count  =0;
        private volatile double average = 0.0;

        // critical section
        public synchronized void addSample(long sample){
            double currentSum = average*count;
            count++;
            average = (currentSum+sample)/count;
        }

        public long getCount()
        {
            return count;
        }

        public double getAverage()
        {
            return average;
        }
    }
}
