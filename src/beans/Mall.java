package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class contains the mall object and its related methods
 * @author Casey
 * @version 1.0 11/13/2012
 */
public class Mall implements Serializable {

    private String mallName;
    private ArrayList<Store> stores;
    private ArrayList<Customer> customers;

    /**
     * Full Constructor - used to create a new mall
     * @param name the mall's name
     */
    public Mall(String name) {
        mallName = name;
        stores = new ArrayList<Store>();
        customers = new ArrayList<Customer>();
    }

    public String toString() {
        String ans;
        ans = "SHOP AT THE " + mallName + " MALL!  BEST IN THE WORLD!!!";
        ans = ans + "\nCurrent stores and items: \n";
        for (int i = 0; i < stores.size(); i++) {
            Store s = stores.get(i);
            ans = ans + s.toString() + "\n";
        }
        return ans;
    }

    /**
     * method that prints the mall object's customers
     * @return string of customer objects
     */
    public String mallCustomers() {
        String ans;
        ans = "Current mall customers: \n";
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            ans = ans + c.toString() + "\n";
        }
        return ans;
    }

    /**
     * method that loads the fake store data into the mall's argument
     */
    public void loadStoreData() {
        BookStore bs = new BookStore("Wolff's Books", "BS1");
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Java IS Fun", "ISBN45", "BS1", 25.00, 50));
        items.add(new Item("Database for Everyone", "ISBN65", "BS1", 82.00, 30));
        items.add(new Item("MySQL Rules", "ISBN67", "BS1", 49.00, 40));
        items.add(new Item("Baseball for Dummies", "ISBN76", "BS1", 79.00, 50));
        bs.setItems(items);
        stores.add(bs);

        GameStore gs = new GameStore("Play With Us", "GS1");
        ArrayList<Item> items2 = new ArrayList<Item>();
        items2.add(new Item("Bopit", "G100", "GS1", 25.00, 12));
        items2.add(new Item("ChutesNLadders", "G110", "GS1", 15.00, 40));
        items2.add(new Item("Barbie", "G120", "GS1", 20.00, 50));
        items2.add(new Item("MLB", "G130", "GS1", 45.00, 60));
        gs.setItems(items2);
        stores.add(gs);

        BookStore bs2 = new BookStore("Amazon.com", "BS2");
        ArrayList<Item> items3 = new ArrayList<Item>();
        items3.add(new Item("Java Certification", "ISBN988", "BS2", 31.00, 40));
        items3.add(new Item("MySQL Database Certification", "ISBN123", "BS2", 66.00, 30));
        items3.add(new Item("MySQL for Dummies", "ISBN455", "BS2", 82.56, 23));
        items3.add(new Item("Server Side Java", "ISBN833", "BS2", 73.54, 50));
        bs2.setItems(items3);
        stores.add(bs2);
    }

    /**
     * method that loads the fake customer data into the mall's argument
     */
    public void loadCustData() {
        customers.add(new Customer("Mouse", "Mickey"));
        customers.add(new Customer("Duck", "Donald"));
        customers.add(new Customer("Dog", "Pluto"));
        customers.add(new Customer("Mouse", "Minnie"));
    }

    // needs getters and setters
    /**
     * method to return an arraylist of store objects
     * @return arraylist of stores
     */
    public ArrayList<Store> getStores() {
        return stores;
    }

    /**
     * sets the mall's arraylist store argument
     * @param stores
     */
    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

    /**
     * method to return an arraylist of customer objects
     * @return arraylist of customers
     */
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    /**
     * sets the mall's arraylist customer parameter
     * @param customers arraylist of customer objects
     */
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    /**
     * method to return the mall's name
     * @return string of the mall's name
     */
    public String getMallName() {
        return mallName;
    }

    /**
     * method to set the mall's name
     * @param mallName string containing the mall's current name
     */
    public void setMallName(String mallName) {
        this.mallName = mallName;
    }
}