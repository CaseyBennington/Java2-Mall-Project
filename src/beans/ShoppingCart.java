package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class containing method for the shopping cart object
 * @author Casey
 * @version 1.0 11/13/2012
 */
public class ShoppingCart implements Serializable {

    private Customer cust;
    private ArrayList<Item> items =new ArrayList<Item>();

    // needs constructors
    /**
     * Full Constructor - used to create a new shopping cart
     * @param c customer object
     */
    public ShoppingCart(Customer c) {
        cust = c;
    }

    /**
     * shopping cart empty constructor
     */
    public ShoppingCart() {
    }

    public String toString() {
        String ans;
        ans = "The items currently in your shopping cart:\n";
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            ans = ans + item.toStringC() + "\n";
        }
        return ans;
    }

    /**
     * method to add an item object to the cart
     * @param item item object
     */
    public void addItem(Item item) {
        items.add(item);
    }
    // needs setters and getters

    /**
     * method to return a customer object
     * @return customer object
     */
    public Customer getCust() {
        return cust;
    }

    /**
     * sets the shopping cart's customer argument
     * with a customer object
     * @param cust customer object
     */
    public void setCust(Customer cust) {
        this.cust = cust;
    }

    /**
     * returns an arraylist of item objects
     * @return arraylist of item objects
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * sets the shopping cart's item argument
     * with arraylist of item objects
     * @param items arraylist of item objects
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}