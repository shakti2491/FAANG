package concurrent;

 class Processor
{
    Object lock = new Object();
    public void producer() throws InterruptedException{

        synchronized (this){
            System.out.println("We are in producer method...");
            wait(1000);

            System.out.println("Again Producer Thread....");
        }
    }

    public void consumer() throws InterruptedException{

        synchronized (this){
            System.out.println("Consumer thread...");
            notify();
        }

    }
}

class App{
    public static void main(String[] args) throws InterruptedException
    {
        Processor processor = new Processor();

        Thread t1 = new Thread(()-> {
            try
            {
                processor.producer();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(() -> {
            try
            {
                processor.consumer();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });

        t2.start();
        t1.start();


        t1.join();
        t2.join();
    }



}
