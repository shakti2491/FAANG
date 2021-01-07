package ood.dogdoor;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoorImpl implements DogDoor
{
    boolean open = false;
    @Override public void open()
    {

        System.out.println("Door opens!!!!");
        open = true;
        final Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override public void run()
            {
                close();
                timer.cancel();
            }
        },5000);
    }

    @Override public void close()
    {
        System.out.println("Door closes!!!");
        open = false;
    }

    @Override public boolean isOpen()
    {
        return this.open;
    }
}
