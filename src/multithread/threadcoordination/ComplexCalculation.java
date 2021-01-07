package multithread.threadcoordination;

import java.math.BigInteger;

public class ComplexCalculation {
    public static void main(String[] args)
    {
        System.out.println(new ComplexCalculation().calculateResult(new BigInteger("10"),new BigInteger("2"),new BigInteger("12"),new BigInteger("2")));
    }

    public BigInteger calculateResult(BigInteger base1,
            BigInteger power1,
            BigInteger base2,
            BigInteger power2) {
        BigInteger result;
        PowerCalculating powerCalculating1 = new PowerCalculating(base1,power1);
        PowerCalculating powerCalculating2 = new PowerCalculating(base2,power2);

        Thread thread1 = new Thread(powerCalculating1);
        Thread thread2 = new Thread(powerCalculating2);

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = powerCalculating1.getResult().add(powerCalculating2.getResult());
        return result;
    }

    private static class PowerCalculating implements Runnable {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculating(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        public void run() {
            result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO;
                i.compareTo(power) !=0;
                i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
