package multithread.readwrite;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main
{
    public static final int HIGHEST_PRICE = 1000;

    public static void main(String[] args) throws InterruptedException
    {
        InventoryDataBase db = new InventoryDataBase();
        Random random = new Random();
        for(int i=0;i<10000;i++){
            db.addItem(random.nextInt(HIGHEST_PRICE));
        }

        Thread writer = new Thread(()->{
            while(true)
            {
                db.addItem(random.nextInt(HIGHEST_PRICE));
                db.removeItem(random.nextInt(HIGHEST_PRICE));

                try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException ex)
                {

                }
            }
        });

        writer.setDaemon(true);
        writer.start();
        int numberOfThreads = 7;
        List<Thread> readers = new ArrayList<>();
        for(int readerIndex=0;readerIndex<numberOfThreads;readerIndex++){
            Thread reader = new Thread(()-> {
                for (int i = 0; i < 100000; i++)
                {
                    int upperBound = random.nextInt(HIGHEST_PRICE);
                    int lowerBound = upperBound > 0 ? random.nextInt(upperBound) : 0;
                    db.getNumberOfItemsInPriceRange(lowerBound, upperBound);
                }
            });
            reader.setDaemon(true);
            readers.add(reader);
        }

        long startReadingTime = System.currentTimeMillis();
        for(Thread reader : readers){
            reader.start();
        }

        for(Thread reader : readers){
            reader.join();
        }
        long endReadingTime = System.currentTimeMillis();

        System.out.println(String.format("Reading took %d ms",endReadingTime-startReadingTime));
    }
    public static class InventoryDataBase{
        private TreeMap<Integer,Integer> priceToCountMap = new TreeMap<>();
        private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        private Lock readLock = reentrantReadWriteLock.readLock();
        private Lock writeLock = reentrantReadWriteLock.writeLock();
        public int getNumberOfItemsInPriceRange(int lower, int higher){
            readLock.lock();
            try
            {
                Integer fromKey = priceToCountMap.ceilingKey(lower);
                Integer toKey = priceToCountMap.floorKey(higher);
                if (fromKey == null || toKey == null)
                    return 0;

                NavigableMap<Integer, Integer> rangeOfPrices = priceToCountMap.subMap(fromKey, true, toKey, true);

                int sum = 0;
                for (int numOfItems : rangeOfPrices.values())
                {
                    sum += numOfItems;
                }
                return sum;
            }finally
            {
                readLock.unlock();
            }
        }
        public void addItem(int price){
            writeLock.lock();
            try
            {
                priceToCountMap.put(price, priceToCountMap.getOrDefault(price, 0) + 1);
            }finally
            {
                writeLock.unlock();
            }
        }
        public void removeItem(int price)
        {
            writeLock.lock();
            try
            {
                Integer count = priceToCountMap.get(price);
                if (count == null)
                    throw new IllegalArgumentException("Not a valid price to remove");
                else if (count == 1)
                    priceToCountMap.remove(price);
                else
                    priceToCountMap.put(price, count - 1);
            }finally
            {
                writeLock.unlock();
            }
        }
    }
}
