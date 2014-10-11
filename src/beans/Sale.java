package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class contains the sale object and its related methods
 * @author Casey
 * @version 1.0 11/13/2012
 */
public class Sale implements Serializable {

    private int saleID;
    private Customer cust;
    private ArrayList<Item> items;
    /**
     * 
     */
    public static int nextNum = 1000;

    // needs constructors
    /**
     * Full Constructor - used to create a new sale
     * @param c
     * @param i
     */
    public Sale(Customer c, ArrayList<Item> i) {
        cust = c;
        items = i;
        saleID = nextNum;
        nextNum++;
    }

    /**
     * empty constructor but still creates a unique id for them
     */
    public Sale() {
        saleID = nextNum;
        nextNum++;
    }

    public String toString() {
        String ans;
        ans = "Sale ID: " + saleID + " for " + cust.toString() + "\n";
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            ans = ans + item.toStringC() + "\n";
        }
        return ans;
    }

    // needs getters and setters
    /**
     * returns the customer object relate to the sale object
     * @return the sale object's related customer object
     */
    public Customer getCust() {
        return cust;
    }

    /**
     * sets the sale's customer object
     * @param cust Customer object
     */
    public void setCust(Customer cust) {
        this.cust = cust;
    }

    /**
     * returns an arraylist of items
     * @return arraylist of item objects
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * sets the sale's arraylist of items
     * @param items arraylist of item objects
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}