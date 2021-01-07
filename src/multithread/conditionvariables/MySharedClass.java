package multithread.conditionvariables;

public class MySharedClass
{
    private boolean isComplete = false;
    public void waitUntilComplete() throws InterruptedException
    {
        synchronized (this){
            while(isComplete == false)
                this.wait();
        }
    }

    public void complete(){
        synchronized (this){
            isComplete = true;
            this.notify();
        }
    }
}
