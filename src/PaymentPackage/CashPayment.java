/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS DEALS WITH THE CASH PAYMENT SYSTEM
 used classes : Customer, LoginServer, Movie, Hall, InputOutputClass
 **/
package PaymentPackage;

import MainPackage.Customer;
import MainPackage.LoginServer;
import MoviePackage.Movie;
import PrimitiveClassesPackage.Hall;
import UtilityPackage.InputOutputClass;
public class CashPayment extends Payment {

    /**THIS IS A SINGLE IMPLEMENTATION FOR THE MOVIE ONLY**/
    public boolean pay(Customer customer, Movie movie)  {
        if (!(customer.getCashBalance() - movie.getTicketPrice() >= 0)) {
            return false;
        }
        var newBalance = customer.getCashBalance() - movie.getTicketPrice();
        customer.setCashBalance(newBalance);
        /**UPDATING OUR USER**/
        try {
            InputOutputClass.writeUser(LoginServer.usersList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    /***PrimitiveClassesPackage.Hall implementation*/
    public boolean pay(Customer customer, Hall hall)  {
        if (!(customer.getCashBalance() - hall.getHallCharges() >= 0)) {
            return false;
        }
        var newBalance = customer.getCashBalance() - hall.getHallCharges();
        customer.setCashBalance(newBalance);
        /**UPDATING OUR USER**/
        try {
            InputOutputClass.writeUser(LoginServer.usersList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /***NEW HALL IMPLEMENATION**/
    public boolean pay(Double hallPrice)  {

        System.out.println("New placeholder tick price: " + hallPrice);
   /*  if (!(MainPackage.LoginServer.currentUser.getCashBalance() - ticket.getHall().getHallPrice() >= 0)) {
         return false;
     }*/
        var newBalance = LoginServer.currentUser.getCashBalance() - hallPrice;




        LoginServer.currentUser.setCashBalance(newBalance);
        /**UPDATING OUR USER**/
        try {
            InputOutputClass.writeUser(LoginServer.usersList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    /***Food implementation**/
    public boolean pay (Customer customer, double price) {
        if (!(customer.getCashBalance() - price >= 0)) {
            return false;
        }
        var newBalance = customer.getCashBalance() - price;
        customer.setCashBalance(newBalance);
        /**UPDATING OUR USER**/
        try {
            InputOutputClass.writeUser(LoginServer.usersList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }




    /*
    public Double getAmount () {
        return amount;
    }*/
}


