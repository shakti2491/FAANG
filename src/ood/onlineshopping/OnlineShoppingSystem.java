package ood.onlineshopping;

import java.util.Date;
import java.util.List;

public class OnlineShoppingSystem
{
}
class Item{
    private String productId;
    private int quantity;
    private double price;
    public double getPrice(){ return price;}
}

abstract class  ShoppingCart{
   private List<Item> items;
    public abstract boolean addItems(Item item);
    public abstract boolean removeItem(Item item);
    public abstract boolean updateQuantities(Item item, int quantity);
    public abstract List<Item> getItems();
    public double calcTotalCost() {
        double total = 0.0;
        for (Item item : items) {

            total += item.getPrice();
        }
        return total;
    }

    public  boolean checkOut(PaymentMethod method){
        // place Order
        // do Payment
        return method.pay(calcTotalCost());
    }

}

class ProductCategory{
    String name;
    String description;
}

class Product{
    private String productId;
    private String name;
    private String description;
    private double price;
    private ProductCategory productCategory;
    private int availableCount;


}


abstract class Customer {
    private ShoppingCart cart;
    private Order order;

    abstract ShoppingCart getShoppingCart();
    abstract Order placeOrder(ShoppingCart cart);
}

abstract class Order{
    private String orderNumber;
    private Date orderDate;
    private List<OrderLog> orderLog;

    public abstract boolean sendForShipment();
    public abstract boolean makePayment();
}


 enum OrderStatus {
    UNSHIPPED, PENDING, SHIPPED, COMPLETED, CANCELED, REFUND_APPLIED
}
class OrderLog {
    private String orderNumber;
    private Date creationDate;
    private OrderStatus status;
}

 interface PaymentMethod {

    public boolean pay(double amount);

}

 class Visa implements PaymentMethod {

    private final String name;
    private final String cardNumber;
    private final Date expires;

    public Visa(String name, String cardNumber, Date expires) {
        super();
        this.name = name;
        this.cardNumber = cardNumber;
        this.expires = expires;
    }

    @Override
    public boolean pay(double amount) {

        // Open Comms to Visa
        // Verify connection
        // Paybill using these details
        return true; // if payment goes through
    }

}

class MasterCard implements PaymentMethod {

    private final String name;
    private final String cardNumber;
    private final Date expires;

    public MasterCard(String name, String cardNumber, Date expires) {
        super();
        this.name = name;
        this.cardNumber = cardNumber;
        this.expires = expires;
    }

    @Override
    public boolean pay(double amount) {

        // Open Comms to Mastercard
        // Verify connection
        // Paybill using these details
        return true; // if payment goes through
    }

}
