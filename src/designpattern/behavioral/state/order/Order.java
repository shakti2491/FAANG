package designpattern.behavioral.state.order;

public class Order
{
    private OrderState currState;

    public Order()
    {
        this.currState = new New();
    }

    public double cancel(){
        double charges = currState.handleCancellation();
        currState = new Cancelled();
        return charges;
    }

    public void paymentSuccessful(){
        currState = new Paid();
    }
    public void dispatched(){
        currState = new InTransit();
    }

    public void delivered(){
        currState = new Delivered();
    }
}
