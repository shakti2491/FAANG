package designpattern.behavioral.state.order;

public class New implements OrderState
{
    @Override public double handleCancellation()
    {
        System.out.println("New Order .. No processing to be done");
        return 0;
    }
}
