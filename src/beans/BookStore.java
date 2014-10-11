package beans;

import java.util.ArrayList;

/**
 * This class contains the bookstore object and its related methods
 * @author Casey
 * @version 1.0 11/13/2012
 */
public class BookStore extends Store {

    //no instance variables.  Needs constructors
    /**
     * empty constructor
     */
    public BookStore() {
    }

    /**
     * Full Constructor - used to create a new bookstore
     * @param name
     * @param ID
     */
    public BookStore(String name, String ID) {
        storeName = name;
        items = new ArrayList<Item>();
        storeID = ID;
    }
}