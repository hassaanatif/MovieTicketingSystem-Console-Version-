/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS DEALS WITH THE CREDIT CARD PAYMENT FUNCTIONALITY
 used classes : Customer, LoginServer, Movie, Hall, InputOutputClass

 **/
package PaymentPackage;

import MainPackage.Customer;
import MainPackage.LoginServer;
import MoviePackage.Movie;
import PaymentPackage.Payment;
import PrimitiveClassesPackage.Hall;
import UtilityPackage.InputOutputClass;


public class CreditCardPayment extends Payment {

    public boolean pay(Customer customer, Movie movie) {
        if (!(customer.getCreditCardBalance() - movie.getTicketPrice() >= 0)) {

            return false;
        }
        customer.setCreditCardBalance(customer.getCashBalance() - movie.getTicketPrice());

          return true;
    }

    /***NEW HALL IMPLEMENATION**/
    public boolean pay(Double hallPrice)  {

        var newBalance = LoginServer.currentUser.getCreditCardBalance() - hallPrice;




        LoginServer.currentUser.setCreditCardBalance(newBalance);
        /**UPDATING OUR USER**/
        try {
            InputOutputClass.writeUser(LoginServer.usersList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**PrimitiveClassesPackage.Hall implementation**/
    public boolean pay(Customer customer, Hall hall) {
        if (!(customer.getCreditCardBalance() - hall.getHallCharges() >= 0)) {

            return false;
        }
       customer.setCreditCardBalance(customer.getCashBalance() - hall.getHallCharges());

        return true;
    }
    /***Food implementation**/
    @Override
    public boolean pay (Customer customer, double price) {
        if (!(customer.getCreditCardBalance() - price >= 0)) {
            return false;
        }
        var newBalance = customer.getCreditCardBalance() - price;
        customer.setCreditCardBalance(newBalance);
        return true;
    }

}
