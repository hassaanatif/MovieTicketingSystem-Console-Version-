package FoodPackage; /**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS RESPONSIBLE FOR BEVERAGES (DRINKS)
 used classes : Customer, Payment, ConsoleClass
 **/

import MainPackage.Customer;
import PaymentPackage.Payment;
import UtilityPackage.ConsoleClass;
import UtilityPackage.InputOutputClass;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Beverages implements  FoodManager, Serializable {
    /**THIS CLASS IS RESPONSIBLE FOR BEVERAGES (DRINKS)**/

    HashMap<String, Double> beverages = new HashMap<>();

   public Beverages() {

       /**I am adding my items here by default in the constructor.
        * But we can obviously take advantage of the CinemaManagementClass and call the method from there
        */
      /* add("Fanta", 50.0);
       add("Cola", 60.0);
       add("Soda", 54.0);*/


        //InputOutputClass.writeBeverages(beverages);

       /***UPDATE:
        * I AM NOW READING MY DATA FROM THE INPUTOUTPUT CLASS
        */

       try {
           beverages = InputOutputClass.readBeverages();
       }
       catch (Exception e) {
           System.out.println("Looks like we've encountered an error in the fast food class");
       }
   }
    @Override
    public void buy(Payment payment, Customer customer) {

      var result= ConsoleClass.foodPrompt(beverages, customer, payment);
        if(result == true) {
            System.out.println("Thank you for your purchase");

        }
        else {
            System.out.println("Sorry, insufficient balance");
        }
    }

    @Override
    public void printAvailableItems() {
        System.out.println("Available FoodPackage.Beverages: ");
        for(Map.Entry<String, Double> map : beverages.entrySet()) {
            System.out.println(map.getKey() + " for $" + map.getValue());
        }
    }

    @Override
    public void add(String foodName, Double foodAmount) {
        beverages.put(foodName, foodAmount);

    }
}
