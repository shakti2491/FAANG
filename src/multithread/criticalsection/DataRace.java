package multithread.criticalsection;

/**
 *  A data race occurs when 2 instructions from different threads access the same memory location,
 *  at least one of these accesses is a write
 *  and there is no synchronization that is mandating any particular order among these accesses.
 */
public class DataRace
{
    public static void main(String[] args)
    {
        SharedClass sharedClass = new SharedClass();
        Thread t1 = new Thread(()->{
            while (true){
                sharedClass.increment();
            }
        });
        Thread t2 = new Thread(()->{
            while (true){
                sharedClass.checkForDataRace();
            }
        });

        t1.start();
        t2.start();
    }

    private static class SharedClass{
        private  int x = 0;
        private  int y = 0;

        public void increment(){
            x++;
            y++;
        }

        // Invariant x>=y
        public void checkForDataRace(){
            if(y>x)
                System.out.println("Data Race Detected.");
        }
    }
}
