/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS NO LONGER IN USE
 used classes : Customer, LoginServer, Movie, Hall, InputOutputClass

 **/

package PaymentPackage;

import MainPackage.Customer;
import MainPackage.LoginServer;
import MoviePackage.Movie;
import PrimitiveClassesPackage.Hall;
import UtilityPackage.InputOutputClass;



public class ChequePayment extends Payment {

    public boolean pay(Customer customer, Movie movie) {
        if (!(customer.getBankBalance() - movie.getTicketPrice() >= 0)) {
             return false;
        }
        customer.setBankBalance(customer.getCashBalance() - movie.getTicketPrice());

        return  true;
    }

    /***NEW HALL IMPLEMENATION**/
    public boolean pay(Double hallPrice)  {

        var newBalance = LoginServer.currentUser.getBankBalance() - hallPrice;




        LoginServer.currentUser.setBankBalance(newBalance);
        /**UPDATING OUR USER**/
        try {
            InputOutputClass.writeUser(LoginServer.usersList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**HALL implementation**/
    public boolean pay(Customer customer, Hall hall) {
        if (!(customer.getBankBalance() - hall.getHallCharges() >= 0)) {
            return false;
        }
        customer.setBankBalance(customer.getCashBalance() - hall.getHallCharges());

        return  true;
    }

    @Override
    public boolean pay(Customer customer, double price) {
        if (!(customer.getBankBalance() - price >= 0)) {
            return false;
        }
        var newBalance = customer.getBankBalance() - price;
        customer.setBankBalance(newBalance);
        return true;
    }

}
