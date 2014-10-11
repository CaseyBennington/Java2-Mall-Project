package beans;

import java.util.ArrayList;

/**
 * This class contains the gamestore object and its related methods
 * @author Casey
 * @version 1.0 11/13/2012
 */
public class GameStore extends Store {

    //needs constructors
    /**
     * empty constructor
     */
    public GameStore() {
    }

    /**
     * Full Constructor - used to create a new gamestore
     * @param name
     * @param ID
     */
    public GameStore(String name, String ID) {
        storeName = name;
        items = new ArrayList<Item>();
        storeID = ID;
    }
}