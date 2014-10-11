package beans;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 * This class contains the item object and its related methods
 * @author Casey
 * @version 1.0 11/13/2012
 */
public class Item implements Serializable, Cloneable {

    private String itemName;
    private String itemID;
    private String storeID;
    private double price;
    private int number;

    // needs constructors
    /**
     * Full Constructor - used to create a new item
     * @param name - Item name
     * @param ID - Item ID
     * @param store - Item's store that stocks the item
     * @param p - Item price
     * @param num - number of Items
     */
    public Item(String name, String ID, String store, Double p, Integer num) {
        itemName = name;
        itemID = ID;
        storeID = store;
        price = p;
        number = num;
    }

    /**
     * empty constructor
     */
    public Item() {
    }

    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return itemID + ": " + itemName + " in store "
                + storeID + " cost " + nf.format(price)
                + " and there are " + getNumber() + " in stock.";
    }

    // used for the customer to see
    /**
     * method to return a string used for the customer to see
     * @return string of item objects
     */
    public String toStringC() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return itemID + ": " + itemName + " from store "
                + storeID + " cost " + nf.format(price)
                + " and you bought " + getNumber() + " of them.";
    }
    //needs getters and setters

    /**
     * method to return the item's name
     * @return item's name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * sets the Item name
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * method that returns the item's ID
     * @return item's ID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * sets the item ID
     * @param itemID
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     * returns the item's store ID
     * @return item's Store ID
     */
    public String getStoreID() {
        return storeID;
    }

    /**
     * sets the item's store ID
     * @param storeID string containing the item's store ID
     */
    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    /**
     * method that returns the item's price
     * @return item's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * sets the item's price
     * @param price double containing the item's price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * returns the quantity of items
     * @return quantity of items
     */
    public int getNumber() {
        return number;
    }

    /**
     * sets the item's quantity
     * @param number integer containing the item's quantity
     */
    public void setNumber(int number) {
        this.number = number;
    }
}