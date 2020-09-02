/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS DEALS WITH KEEPING A TRACK OF THE FAST FOOD
 used classes : Customer, Payment, ConsoleClass
 **/
package FoodPackage;

import MainPackage.Customer;
import PaymentPackage.Payment;
import UtilityPackage.ConsoleClass;
import UtilityPackage.InputOutputClass;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FastFood implements Serializable, FoodManager {
    HashMap<String, Double> fastFoodList = new HashMap<>();
    public FastFood() {
        /**I am adding my items here by default in the constructor.
         * But we can obviously take advantage of the CinemaManagementClass and call the method from there
         */
   /*     add("Pizza", 205.0);
        add("Burger", 50.0);
        add("Fries", 90.0);
        add("Zinger", 100.0);*/

       // InputOutputClass.writeFastFood(fastFoodList);

        /***UPDATE:
         * I AM NOW READING MY DATA FROM THE INPUTOUTPUT CLASS
         */

        try {
            fastFoodList = InputOutputClass.readFastFood();
        }
        catch (Exception e) {
            System.out.println("Looks like we've encountered an error in the fastfood class :((");
        }

    }
    @Override
    public void buy(Payment payment, Customer customer) {
       var result = ConsoleClass.foodPrompt(fastFoodList, customer,  payment);
        if(result == true) {
            System.out.println("Thank you for your purchase");

        }
        else {
            System.out.println("Sorry, insufficient balance");
        }
    }

    @Override
    public void printAvailableItems() {
        System.out.println("Available Food items: ");
        for(Map.Entry<String, Double> map : fastFoodList.entrySet()) {
            System.out.println(map.getKey() + " for $" + map.getValue());
        }
    }

    @Override
    public void add(String foodName, Double foodAmount) {
      fastFoodList.put(foodName, foodAmount);
    }
}
