 /**Project name :Melite-Meu (MovieTicketingSystem)
   Roll no:  0147-BSCS-2019 (Section C)
   Description: This class is responsible for keeping a track of snacks
  used classes : Customer, Payment, ConsoleClass
**/
package FoodPackage;
import MainPackage.Customer;
import PaymentPackage.Payment;
import UtilityPackage.ConsoleClass;
import UtilityPackage.InputOutputClass;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Snacks implements FoodManager, Serializable {
    private HashMap<String, Double> snacklist = new HashMap<>();

    public Snacks()  {
        /**I am adding my items here by default in the constructor.
         * But we can obviously take advantage of the CinemaManagementClass and call the method from there
         */
    /*    add("Popcorn", 50.0);
        add("Biscuit", 50.0);
        add("Chips", 60.0);
        add("Toffee", 70.0);*/
   /*
     */
        /***UPDATE:
         * I AM NOW READING MY DATA FROM THE INPUTOUTPUT CLASS
         */

        try {
            snacklist = InputOutputClass.readSnacks();
        }
        catch (Exception e) {
            System.out.println("Oopsie! An error occured inside the snacks class :(");
        }

        }

    @Override
    public void buy(Payment payment, Customer customer) {
         var result = ConsoleClass.foodPrompt(snacklist, customer, payment);
        if(result == true) {
            System.out.println("Thank you for your purchase");


        }
        else {
            System.out.println("Sorry, insufficient balance");
        }
    }

    @Override
    public void printAvailableItems() {
        System.out.println("Available snack items: ");
        for(Map.Entry<String, Double> map : snacklist.entrySet()) {
            System.out.println(map.getKey() + " for $" + map.getValue());
        }
    }

    @Override
    public void add(String foodName, Double foodAmount) {
        snacklist.put(foodName, foodAmount);
    }
}
