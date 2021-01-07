package ood.shoppingcart;

import java.util.*;

// This class is a simple container of shopping cart items.
// It is observable, which means that it notifies any interested
// classes whenever it changes.

public class ShoppingCart extends Observable
{
    protected List<ShoppingCartItem> items;	// the items in the cart
    protected int total;	// the total item cost so far

    public ShoppingCart()
    {
        items = new Vector();
        total = 0;
    }

    // Add a new item and update the total

    public void addItem(ShoppingCartItem newItem)
    {

        // See if there's already an item like this in the cart
        int currIndex = items.indexOf(newItem);
        if (currIndex == -1) {
            // If the item is new, add it to the cart
            items.add(newItem);

        } else {

            // If there is a similar item, just add the quantities
            ShoppingCartItem currItem =
                            items.get(currIndex);

            currItem.add(newItem);

        }

        total += newItem.itemCost * newItem.quantity;

    }

    // Remove item removes an item from the cart. Since it removes
    // n items from the cart at a time, if there are more than n items
    // in the cart, it just subtracts n from the quantity.

    public void removeItem(ShoppingCartItem oldItem)
    {
        // Find this object in the cart
        int currIndex = items.indexOf(oldItem);

        if (currIndex == -1) {
            // If it wasn't there, just return, assume everything's okay
            return;
        } else {
            ShoppingCartItem currItem =
                            items.get(currIndex);

            // If you are trying to subtract more items than are in the cart,
            // adjust the amount you want to subtract so it is equal to the
            // number of items in the cart.

            if (oldItem.quantity > currItem.quantity) {
                oldItem.quantity = currItem.quantity;
            }

            // Adjust the total
            total -= oldItem.itemCost * oldItem.quantity;

            currItem.subtract(oldItem);


            // If the quantity drops to 0, remove the item entirely

            if (currItem.quantity == 0) {
                items.get(currIndex);
            }

        }

    }

    // getItems returns a copy of all the items in the cart

    public ShoppingCartItem[] getItems()
    {
        ShoppingCartItem[] itemArray =
                new ShoppingCartItem[items.size()];

      return items.toArray(itemArray);
    }
}
