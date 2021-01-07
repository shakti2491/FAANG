package multithread.lockfreedatastructure;

import java.util.concurrent.atomic.AtomicReference;

public class Main
{
    public static void main(String[] args)
    {
        String oldName = "old Name";
        String newName = "new Name";
        AtomicReference<String> atomicReference = new AtomicReference<>(oldName);
        oldName = " unexpected name";
        if(atomicReference.compareAndSet(oldName,newName)){
            System.out.println("New Value is "+ atomicReference.get());
        }else{
            System.out.println("Nothing happened");
        }
    }
}
