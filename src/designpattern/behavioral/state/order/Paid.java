package designpattern.behavioral.state.order;

public class Paid implements OrderState
{
    @Override public double handleCancellation()
    {
        System.out.println("Contacting payment gateway to rollback transactions.");
        return 0;
    }
}
