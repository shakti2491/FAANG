package ood.onlineshopping;

import java.util.List;

public class OnlineShoppingSystem
{
}
class Item{
    private String productId;
    private int quantity;
    private double price;
}

abstract class  ShoppingCart{
   private List<Item> items;
    public abstract boolean addItems(Item item);

}
abstract class Customer{

}
