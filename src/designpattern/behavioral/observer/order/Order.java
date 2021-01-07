package designpattern.behavioral.observer.order;

import java.util.ArrayList;
import java.util.List;

public class Order
{
    private String id;
    private double itemCost;
    private int count;
    private double discount;
    private double shippingCost;

    private List<OrderObserver> observerList = new ArrayList<>();
    public void attach(OrderObserver observer){
        observerList.add(observer);
    }

    public void detach(OrderObserver observer)
    {
        observerList.remove(observer);
    }
    public Order(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public double getItemCost()
    {
        return itemCost;
    }

    public void setItemCost(double itemCost)
    {
        this.itemCost = itemCost;
    }

    public void addItem(double price){
        itemCost = price;
        count++;
        observerList.forEach(observer -> observer.updated(this));
    }

    public void setShippingCost(double shippingCost)
    {
        this.shippingCost = shippingCost;
    }
}
