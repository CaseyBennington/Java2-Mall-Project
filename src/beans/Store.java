package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class contains the store object and its related methods
 * @author Casey
 * @version 1.0 11/13/2012
 */
public abstract class Store implements Serializable {

    /**
     *
     */
    protected String storeName;
    /**
     *
     */
    protected ArrayList<Item> items;
    /**
     *
     */
    protected String storeID;

    //needs constructors
    /**
     * empty constructor
     */
    public Store() {
    }

    /**
     * Full Constructor - used to create a new store
     * @param name - Store's name
     * @param ID - Store's ID
     */
    public Store(String name, String ID) {
        storeName = name;
        items = new ArrayList<Item>();
        storeID = ID;
    }

    public String toString() {
        String ans = "\nStore ID: " + storeID + "  Store Name: " + storeName;
        ans = ans + "\nItems:";
        for (int i = 0; i < items.size(); i++) {
            ans = ans + "\n      " + items.get(i).toString();
        }
        return ans;
    }
    // needs getters and setters

    /**
     * returns the store's name
     * @return Store's name
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * sets the store's name
     * @param storeName String of the store's name
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * returns the store's arraylist of item objects
     * @return Store's arraylist of item objects
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * sets the Store's arraylist of item objects
     * @param items Arraylist of item objects
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Returns the store's ID
     * @return Store's ID
     */
    public String getStoreID() {
        return storeID;
    }

    /**
     * sets the store's ID
     * @param storeID String of the store's ID
     */
    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }
}