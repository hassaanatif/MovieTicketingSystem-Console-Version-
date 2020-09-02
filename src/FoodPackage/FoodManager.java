package FoodPackage;
/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS INTERFACE IS TO CONTROL THE FOOD SYSTSEM
 used classes : Customer, Payment
 **/

import MainPackage.Customer;
import PaymentPackage.Payment;

import java.io.IOException;

public interface FoodManager  {
    public void buy(Payment payment, Customer customer) throws IOException;
    public void printAvailableItems ();
    public void add(String foodName, Double foodAmount);
}
