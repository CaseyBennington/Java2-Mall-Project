package mall;

import beans.*;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class that executes the body of all the menu
 * items from the mall driver class
 * @author Casey
 * @version 1.0 11/13/2012
 */
public class MenuItem {

    //loadData - menu item 1
    /**
     * method to load fake data in the mall
     * @param m the mall object
     */
    public void loadData(Mall m) {
        try {
            m.loadStoreData();
            m.loadCustData();
        } catch (Exception e) {
            System.out.println("That option did not work, try again.");
        }
    }

    // printData - menu item 2
    /**
     * method to print the mall's data
     * @param m the mall object
     */
    public void printData(Mall m) {
        try {
            System.out.println(m.toString());
            System.out.println(m.mallCustomers());
        } catch (Exception e) {
            System.out.println("That option did not work, try again.");
        }
    }

    //searchItem = menu item 3
    /**
     * method used to search the mall object for an item
     * @param mall the mall object
     */
    public void searchItem(Mall mall) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to search for (1) an item number or (2) part of an item name");
        try {
            int which = scan.nextInt();
            if (which == 1) {
                searchNumber(mall);
            } else {
                searchName(mall);
            }
        } catch (Exception e) {
            System.out.println("Your options are 1 or 2 only.");
        }
    }

    // searchNumber - used in submenu of searchItem
    /**
     * method under searchItem method to search for an item number
     * @param mall the mall object
     */
    public void searchNumber(Mall mall) {
        Boolean empty = true;
        Scanner scan = new Scanner(System.in);
        ArrayList<Store> stores = new ArrayList<Store>();
        ArrayList<Item> items = new ArrayList<Item>();
        stores = mall.getStores();
        String returnMessage = "This item does not exist.";
        System.out.println("What is the item id?");
        try {
            String entry = scan.nextLine();

            for (int i = 0; i < stores.size(); i++) {
                items = stores.get(i).getItems();
                for (int y = 0; y < items.size(); y++) {
                    if (items.get(y).getItemID().contains(entry)) {
                        System.out.println(items.get(y).toString());
                        empty = false;
                    }
                }
            }
            if (empty == true) {
                System.out.println(returnMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("You search could not be completed at this time.");
        }
    }

    // searchName - used in submenu of searchItem
    /**
     * method under searchItem method to search for an item name
     * @param mall the mall object
     */
    public void searchName(Mall mall) {
        Boolean empty = true;
        Scanner scan = new Scanner(System.in);
        ArrayList<Store> stores = new ArrayList<Store>();
        ArrayList<Item> items = new ArrayList<Item>();
        stores = mall.getStores();
        String returnMessage = "No such item exists.";
        System.out.println("What is the name (or part of the name) you want?");
        try {
            String entry = scan.nextLine();

            for (int i = 0; i < stores.size(); i++) {
                items = stores.get(i).getItems();
                for (int y = 0; y < items.size(); y++) {
                    if (items.get(y).getItemName().contains(entry)) {
                        System.out.println(items.get(y).toString());
                        empty = false;
                    }
                }
            }
            if (empty == true) {
                System.out.println(returnMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("You search could not be completed at this time.");
        }
    }

    //addItem - menu item 4
    /**
     * method to add an item to a store object in the mall object
     * @param m the mall object
     */
    public void addItem(Mall m) {
        ArrayList<Store> stores = new ArrayList<Store>();
        ArrayList<Item> items = new ArrayList<Item>();
        stores = m.getStores();
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println(m.toString());
            System.out.println("Which store ID?  (Please enter the store ID seen above.");
            String storeNum = scan.nextLine();
            System.out.println("What is the item ID?");
            String itemID = scan.nextLine();

            int storeIndex = 0;
            int itemIndex = 0;

            Boolean found = false;
            for (int i = 0; i < stores.size(); i++) {
                if (storeNum.equalsIgnoreCase(stores.get(i).getStoreID())) {
                    items = stores.get(i).getItems();
                    for (int y = 0; y < items.size(); y++) {
                        if (items.get(y).getItemID().equalsIgnoreCase(itemID)) {
                            found = true;
                            storeIndex = i;
                            itemIndex = y;
                            break;
                        }
                    }
                }
            }

            if (found == true) {
                int qty = m.getStores().get(storeIndex).getItems().get(itemIndex).getNumber();
                System.out.println("There are already " + qty + " of these items in stock.  We will add more.");
                System.out.println("How many are you putting in stock?");
                int qtyNum = scan.nextInt();

                m.getStores().get(storeIndex).getItems().get(itemIndex).setNumber(qty + qtyNum);
                System.out.println("Stock has been added.");
            } else {
                System.out.println("This is a new item.");
                System.out.println("What is the item name?");
                String itemName = scan.nextLine();
                System.out.println("How many are you putting in stock?");
                int qtyNum = scan.nextInt();
                System.out.println("What is the price of each?");
                double itemPrice = scan.nextDouble();

                for (int i = 0; i < stores.size(); i++) {
                    if (storeNum.equalsIgnoreCase(stores.get(i).getStoreID())) {
                        m.getStores().get(i).getItems().add(new Item(itemName, itemID, storeNum, itemPrice, qtyNum));
                        System.out.println("New item has been added to inventory.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Your item could not be added at this time.  Please try again later.");
        }
    }

    // addCustomer - menu item 5
    /**
     * method to add a customer object to the mall object
     * @param m the mall object
     */
    public void addCustomer(Mall m) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Customer's last name:");

        try {
            String lastName = scan.nextLine();
            System.out.println("Customer's first name:");
            String firstName = scan.nextLine();
            Boolean found = false;
            for (int i = 0; i < m.getCustomers().size(); i++) {
                if ((lastName.equalsIgnoreCase(m.getCustomers().get(i).getLast())) && (firstName.equalsIgnoreCase(m.getCustomers().get(i).getFirst()))) {
                    System.out.println("That customer has already been entered.");
                    found = true;
                    break;
                }
            }
            if (found == false) {
                m.getCustomers().add(new Customer(lastName, firstName));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Your customer could not be added at this time.  Please try again later.");
        }
    }

    //getCart - menu item 6
    /**
     * method to get a cart object for a customer object in the mall object
     * @param m the mall object
     * @return the shopping cart object
     */
    public ShoppingCart getCart(Mall m) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which customer?");
        try {
            for (int i = 0; i < m.getCustomers().size(); i++) {
                System.out.printf("%1d. %10s\n", i + 1, m.getCustomers().get(i));
            }

            int custChoice = scan.nextInt() - 1;
            ShoppingCart cart = new ShoppingCart(m.getCustomers().get(custChoice));
            m.getCustomers().get(custChoice).setCart(cart);

            System.out.println("You now have a cart " + m.getCustomers().get(custChoice).getFirst() + " " + m.getCustomers().get(custChoice).getLast() + " ---happy shopping!");
            return cart;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Your cart could not be created.");
            return null;
        }
    }

    //shop - menu item 7
    /**
     * method for a customer object to shop for item(s)
     * to be placed in the cart object from store object in the mall object
     * @param cart the shopping cart object
     * @param mall the mall object
     */
    public void shop(ShoppingCart cart, Mall mall) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to our shopping mall " + cart.getCust().getFirst() + " " + cart.getCust().getLast());

        try {
            boolean more = true;
            while (more == true) {
                System.out.println("Pick a store:");
                System.out.println("Where do you want to shop?");
                for (int i = 0; i < mall.getStores().size(); i++) {
                    System.out.printf("%1d. %10s\n", i + 1, mall.getStores().get(i).getStoreName());
                }
                System.out.println("Which number?");
                int storeChoice = scan.nextInt() - 1;

                System.out.println("Here are the items in that store:");
                for (int i = 0; i < mall.getStores().get(storeChoice).getItems().size(); i++) {
                    System.out.printf("%1d. %10s\n", i + 1, mall.getStores().get(storeChoice).getItems().get(i).toString());
                }
                System.out.println("Which item do you want?");
                int itemChoice = scan.nextInt() - 1;
                System.out.println("How many do you wish to purchase?");
                int numChoice = scan.nextInt();
                if (numChoice <= mall.getStores().get(storeChoice).getItems().get(itemChoice).getNumber()) {
                    String itemName = mall.getStores().get(storeChoice).getItems().get(itemChoice).getItemName();
                    String itemID = mall.getStores().get(storeChoice).getItems().get(itemChoice).getItemID();
                    String storeID = mall.getStores().get(storeChoice).getItems().get(itemChoice).getStoreID();
                    double price = mall.getStores().get(storeChoice).getItems().get(itemChoice).getPrice();
                    Item tempItem = new Item(itemName, itemID, storeID, price, numChoice);
                    cart.addItem(tempItem);

                    int invChange = (mall.getStores().get(storeChoice).getItems().get(itemChoice).getNumber()) - numChoice;
                    mall.getStores().get(storeChoice).getItems().get(itemChoice).setNumber(invChange);
                    System.out.println("Added to the shopping cart.");
                } else {
                    System.out.println("There are not that many in stock.");
                }

                if (cart.getItems().isEmpty()) {
                    System.out.println("Your cart is empty.");
                } else {
                    System.out.println(cart.toString());
                }

                System.out.println("More to purchase?");
                more = scan.nextBoolean();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("We cannot complete your shopping experience at this time.");
        }
    }

    // checkOut - menu item 8
    /**
     * method to remove items from the cart object
     * and add them to the sales arraylist
     * @param cart the shopping cart object
     * @param sales the arraylist of sales
     */
    public void checkOut(ShoppingCart cart, ArrayList<Sale> sales) {
        try {
            System.out.println("Welcome " + cart.getCust().getFirst() + " " + cart.getCust().getLast());

            sales.add(new Sale(cart.getCust(), cart.getItems()));

            System.out.println("You have purchased the following:");
            System.out.println(cart.toString());

            cart = null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("The checkout process could not be completed at this time.  Please try again later.");
        }
    }

    //listSales - menu itme 9
    /**
     * method to print out the items in the sales arraylist
     * @param sales the arraylist of sales
     */
    public void listSales(ArrayList<Sale> sales) {
        try {
            System.out.println(sales.toString());   //why does the [ ] appear in this output for a toString when on the other methods and toStrings it does not??
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Sales could not be printed.");
        }
    }

    //saveDat - menu item 10
    /**
     * method to save the mall and sales arraylist
     * to a seralizable file
     * @param mall the mall object
     * @param sales the arraylist of sales
     */
    public void saveData(Mall mall, ArrayList<Sale> sales) {
        Frame f = new Frame();
        FileDialog foBox = new FileDialog(f, "Saving customer file", FileDialog.SAVE);
        foBox.setVisible(true);
        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();
        File outFile = new File(dirPath + foName);
        FileOutputStream OS = null;
        ObjectOutputStream OOS = null;

        try {
            OS = new FileOutputStream(outFile);
            OOS = new ObjectOutputStream(OS);

            OOS.writeObject(mall);	// write the entire Mall out at once.
            OOS.writeObject(sales);   // try to write entire sales arraylist next...

            // we also want to save the next customer number
            // now print the next customer number that should be used to the file also
            // need to keep track of this so that when you read the data back in, you do not reuse
            // customer numbers
            OOS.writeInt(Customer.custNum);

        } catch (IOException io) {
            io.printStackTrace();
            System.out.println("An IO Exception occurred");
            System.out.println("File could not be saved.");
        } finally {
            try {
                OOS.close();
            } catch (Exception e) {
            }
        }
    }

    // read Data - menu item 11
    /**
     * method to read a serialized file into the mall object
     * and sales arraylist
     * @return the arraylist al which contains
     * the mall object and arraylist of sales
     */
    public ArrayList readData() {
        // create the ArrayList
        Mall mall = new Mall("Bennington's Shopping Mall");
        ArrayList<Sale> sales = new ArrayList<Sale>();
        ArrayList al = new ArrayList();

        Frame f = new Frame();
        FileDialog foBox = new FileDialog(f, "Reading serialized file", FileDialog.LOAD);
        foBox.setVisible(true);
        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();
        File inFile = new File(dirPath + foName);

        ObjectInputStream OIS = null;
        try {
            FileInputStream IS = new FileInputStream(inFile);
            OIS = new ObjectInputStream(IS);
            mall = (Mall) OIS.readObject(); // note that you can read in the entire object (the mall) at once
            sales = (ArrayList<Sale>) OIS.readObject();  //read in sales as well...
            // now read in that extra piece of data that we wrote out and set the next customer number to use
            Customer.custNum = OIS.readInt();
            al.add(mall);
            al.add(sales);

        } catch (IOException io) {
            io.printStackTrace();
            System.out.println("An IO Exception occurred");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
            System.out.println("An IO Exception occurred");
        } finally {
            try {
                OIS.close();
            } catch (Exception e) {
            }
        }
        return al;
    }
}