package multithread.threadcoordination;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Join
{
    public static void main(String[] args) throws InterruptedException
    {
        List<Long> inputNumbers = Arrays.asList(11111111110L,3435L,35435L,2324L,4656L,23L,345L,234L);
        List<FactorialThread> threads = inputNumbers.stream()
                .map(FactorialThread::new)
                .collect(Collectors.toList());
        threads.forEach(Thread::start);

        for (FactorialThread thread : threads)
        {
            thread.join(2000);
            if(thread.isFinished)
            System.out.println("Factorial of "+thread.getInputNumber()+" is "+thread.getResult());
            else
                System.out.println("In Process");
        }

    }

    public static class FactorialThread extends Thread{
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber){
            this.inputNumber = inputNumber;
        }
        @Override
        public void run(){
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        private BigInteger factorial(long n){
            BigInteger tempResult = BigInteger.ONE;
            for(long i = n;i>0;i--){
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }
            return tempResult;
        }
        public BigInteger getResult()
        {
            return result;
        }

        public boolean isFinished()
        {
            return isFinished;
        }

        public long getInputNumber()
        {
            return inputNumber;
        }
    }
}
