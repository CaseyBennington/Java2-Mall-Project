package mall;

import beans.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Mall Simulation Program for a small one at a time shopping mall
 * @author Casey
 * @version 1.0 11/13/2012
 */
public class MallDriver {

    /**
     * Executes menu for Mall program
     * @param args
     */
    public static void main(String[] args) {
        Mall mall = new Mall("Bennington's Shopping Mall");
        MenuItem mi = new MenuItem();
        ShoppingCart cart = null;
        ArrayList<Sale> sales = new ArrayList<Sale>();
        ArrayList al = new ArrayList();

        int choice = 0;
        while (choice != 12) {
            try {
                choice = menu();

                if (choice == 1) {
                    mi.loadData(mall);
                } else if (choice == 2) {
                    mi.printData(mall);
                } else if (choice == 3) {
                    mi.searchItem(mall);
                } else if (choice == 4) {
                    mi.addItem(mall);
                } else if (choice == 5) {
                    mi.addCustomer(mall);
                } else if (choice == 6) {
                    cart = mi.getCart(mall);
                } else if (choice == 7) {
                    mi.shop(cart, mall);
                } else if (choice == 8) {
                    mi.checkOut(cart, sales);
                } else if (choice == 9) {
                    mi.listSales(sales);
                } else if (choice == 10) {
                    mi.saveData(mall, sales);
                } else if (choice == 11) {
                    al = mi.readData();
                    mall = (Mall) al.get(0);
                    sales = (ArrayList<Sale>) al.get(1);
                } else if (choice == 12) {

                    System.out.println("Bye!!!!!");
                    System.exit(0);
                    choice = 12;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException ime) {
                System.out.println("Your choices are 1 through 12 only.");
            }
        }  // end while            
    }

    /**
     * method that runs through the program's menu options
     * @return the user selected answer
     */
    public static int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choice:");
        System.out.println("   1. Load fake data");
        System.out.println("   2. Print data");
        System.out.println("   3. Search for an item");
        System.out.println("   4. Add an item into inventory ");
        System.out.println("   5. Add a customer");
        System.out.println("   6. Get a shopping cart");
        System.out.println("   7. Shop");
        System.out.println("   8. Check out ");
        System.out.println("   9. List all sales ");
        System.out.println("   10. Save data to a serialized file ");
        System.out.println("   11. Read data from a serialized file ");
        System.out.println("   12. QUIT  ");
        System.out.println("\n CHOICE:");
        int ans = scan.nextInt();
        return ans;
    }
}