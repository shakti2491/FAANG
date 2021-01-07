package multithread.threadcoordination;

import java.io.IOException;

public class Daemon
{
    public static void main(String[] args)
    {
        Thread thread = new Thread(new SleepingThread());
        thread.start();
        thread.interrupt();
    }

    private static class WaitingForUserInput implements Runnable
    {
        @Override public void run()
        {
            try
            {
                while (true)
                {
                    char input = (char) System.in.read();
                    if (input == 'q')
                    {
                        return;
                    }
                }
            }
            catch (IOException e)
            {
                System.out.println("An exception was caught " + e);
            }
            ;
        }

    }

    private static class SleepingThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
