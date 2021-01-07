package parallel;

import java.util.Deque;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class SeqArraySum
{
    public static double seqArraySum(double[] X){
        long startTime = System.nanoTime();
        double sum = 0;
        for(int i =0; i<X.length;i++){
            sum+=1/X[i];
        }

        Deque q;

        long timeInNanos = System.nanoTime() - startTime;
        System.out.println("seqArraySum-->>"+ timeInNanos+"sum-->>"+sum );
        return sum;
    }
}

class ASum extends RecursiveTask<Integer>{
    @Override protected Integer compute()
    {
        ASum a = new ASum();
        ASum b =new  ASum();
        b.fork();
        return a.compute()+ b.join();
    }
}

class SumArray extends RecursiveAction {
    static int SEQUENTIAL_THRESHOLD = 5;
    int lo;
    int hi;
    double arr[];
    double sum;

    public SumArray(int lo, int hi, double[] arr)
    {
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
    }

    @Override protected void compute()
    {
        if(hi-lo <= SEQUENTIAL_THRESHOLD){
            for(int i =lo;i<hi;i++)
                sum+=1/arr[i];
        }else{
            SumArray left = new SumArray(lo, (lo+hi)/2,arr);
            SumArray right = new SumArray((lo+hi)/2,hi,arr);
            left.fork();
            right.compute();
            left.join();
            sum = left.sum+right.sum;
        }

    }
}
