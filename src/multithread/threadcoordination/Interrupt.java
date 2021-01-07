package multithread.threadcoordination;

import java.math.BigInteger;

public class Interrupt
{

    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("23423423453452345"), new BigInteger("23451231234523452345234")));
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
    private static class LongComputationTask implements Runnable{
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power)
        {
            this.base = base;
            this.power = power;
        }

        @Override public void run()
        {
            System.out.println(base+"^"+power+"="+pow(base,power));
        }

        private BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;
            for(BigInteger i = BigInteger.ZERO; i.compareTo(power)!=0; i = i.add(BigInteger.ONE)){
                if(Thread.currentThread().isInterrupted())
                    return BigInteger.ZERO;
                result = result.multiply(base);
            }
            return result;
        }

    }
}
