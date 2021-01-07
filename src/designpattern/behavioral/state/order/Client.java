package designpattern.behavioral.state.order;

public class Client
{
    public static void main(String[] args)
    {
        Order order = new Order();
        order.cancel();
        order.paymentSuccessful();
        order.cancel();
        order.dispatched();
        order.cancel();

    }
}
