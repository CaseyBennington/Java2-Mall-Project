package beans;

import java.io.Serializable;

/**
 * This class contains the customer object and its related methods
 * @author Casey
 * @version 1.0 11/13/2012
 */
public class Customer implements Serializable {

    private String last;
    private String first;
    private int custID;
    private ShoppingCart cart;
    //private Store store;
    /**
     *
     */
    public static int custNum = 1000;

    //needs constructors
    /**
     * Full Constructor - used to create a new customer Creates a new unique id
     * for them
     *
     * @param custLast - Customer last name
     * @param custFirst - Customer first name
     */
    public Customer(String custLast, String custFirst) {
        last = custLast;
        first = custFirst;
        custID = custNum;
        custNum++;
    }

    /**
     * Full Constructor - used to create a new customer
     * with an already known customer ID
     * @param custLast - Customer last name
     * @param custFirst - Customer first name
     * @param Num - Customer ID
     */
    public Customer(String custLast, String custFirst, Integer Num) {
        last = custLast;
        first = custFirst;
        custID = Num;
    }

    /**
     * empty constructor but still creates a unique id for them
     *
     */
    public Customer() {
        custID = custNum;
        custNum++;
    }

    public String toString() {
        return "CustID: " + getCustID() + "  " + getFirst() + " " + getLast();
    }
    // needs getters and setters

    /**
     * method that returns the customer's last name
     * @return customer last name
     */
    public String getLast() {
        return last;
    }

    /**
     * set customer last name
     * @param last String of the customer's last name
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     * method that returns the customer's first name
     * @return customer first name
     */
    public String getFirst() {
        return first;
    }

    /**
     * set customer first name
     * @param first String of the customer's first name
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * method that returns the customer's ID
     * @return Customer ID
     */
    public int getCustID() {
        return custID;
    }

    /**
     * set customer ID
     * @param custID Integer of the customer ID
     */
    public void setCustID(int custID) {
        this.custID = custID;
    }

    /**
     * returns the customer's shopping cart object
     * @return shopping cart object
     */
    public ShoppingCart getCart() {
        return cart;
    }

    /**
     * sets the customer's shopping cart object
     * @param cart shoppingcart object
     */
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
}