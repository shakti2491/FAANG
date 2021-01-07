package designpattern.behavioral.observer.order;

public class PriceObserver implements OrderObserver
{
    @Override public void updated(Order order)
    {
        double total = order.getItemCost();
        if(total>=200){
            order.setShippingCost(10);
        }else{
            order.setShippingCost(5);
        }
    }
}
