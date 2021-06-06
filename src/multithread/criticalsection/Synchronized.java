package multithread.criticalsection;

/*
when thread1 is executing  increment=counter1 ; thread2 can execute increment ounter2
this is because the synchronised blocks inside those methods are on differnet lock objects

 */
public class Synchronized
{
    public static void main(String [] args) {
        SharedClass sharedObject = new SharedClass();

        Thread thread1 = new Thread(() -> {
            while (true) {
                sharedObject.incrementCounter1();
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                sharedObject.incrementCounter2();
            }
        });

        thread1.start();
        thread2.start();
    }

    static class SharedClass {
        private int counter1 = 0;
        private int counter2 = 0;

        //Two locks for two shared resources
        // we don't we want
        private Object lock1 = new Object();
        private Object lock2 = new Object();

        public void incrementCounter1() {
            synchronized (lock1) {
                this.counter1++;
            }
        }

        public void incrementCounter2() {
            synchronized (lock2) {
                this.counter2++;
            }
        }
    }
}
