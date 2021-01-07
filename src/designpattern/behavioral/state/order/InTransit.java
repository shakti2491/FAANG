package designpattern.behavioral.state.order;

public class InTransit implements OrderState
{
    @Override public double handleCancellation()
    {
        System.out.println("Contacting courier service for cancellation");
        System.out.println("Contacting payment gateway for transaction rollback");
        return 20;
    }
}
