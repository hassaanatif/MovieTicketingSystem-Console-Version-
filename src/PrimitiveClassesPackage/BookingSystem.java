/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS NO LONGER IN USE
 used classes: Customer, Movie, Payment, ConsoleClass, CinemaManagementSystem, Hall, PremiumHall, Standard Hall
 **/

package PrimitiveClassesPackage;
import MainPackage.CinemaManagementSystem;
import MainPackage.Customer;
import MoviePackage.Movie;
import PaymentPackage.Payment;
import PrimitiveClassesPackage.Hall;
import UtilityPackage.ConsoleClass;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/***NOTE:
 * THIS WAS THE OLD BOOKING CLASS. I AM NO LONGER USING IT BECAUSE IT IS NOT A "PROPER" OBJECT ORIENTED APPROACH. THERE IS POTENTIAL
 * FOR ME TO DERIVE A LOT OF ENTITIES. YES, USING NESTED HASHMAPS WORKED, BUT WAS IT A CLEVER APPROACH? ABSOLUTELY NOT! PLEASE HEAD
 * -OVER TO THE "HallPackage.BookingSystemV2" CLASS. THANK YOU!
 */




public class BookingSystem {
/**we are assuming that this program is currently only expected to run on a single day at the Cinema**/
    private HashMap<HashMap<LocalTime, Hall>, Movie> ticketsAvailable = new HashMap<>();
   // private ArrayList<MainPackage.Customer> customers = new ArrayList<>();
     private Map<Customer, Hall> customers = new HashMap<>();
    BookingSystem () {
    }

    /**So I am using a nested hashMap and here are the reasons:
      1. Each timing will have it's own unique film, and a unique hall
     */
    public void bookMovie (Customer customer,  Movie movie, LocalTime timeOfTheFilm,Hall hallType, Payment payment) {
    //payment.pay(customer,movie)
        //payment.pay(customer, hallType)
        if(payment.pay(customer, hallType) && payment.pay(customer,movie)) {
           hallType.setNumberOfSeats(hallType.getNumberOfSeats() - 1);

            HashMap<LocalTime, Hall> innerHashMap = new HashMap<>();
            innerHashMap.put(timeOfTheFilm, hallType);
            ticketsAvailable.put(innerHashMap, movie);

            customers.put(customer, hallType);
            System.out.println("Thank you for your purchase");
            System.out.println("And as a funfact the remaining seats are: " + hallType.getNumberOfSeats());
        }
        else {
            System.out.println("Sorry insufficient balance");
        }
    }


    //Overloaded
    public void refundMovie (String customer, String movietoRefund) {
        Customer indexOfCustomer = findCustomer(customer);
        var getMovie = CinemaManagementSystem.movieManager.findAvailableFilm(movietoRefund);

        if(indexOfCustomer != null || getMovie != -1) {
            Double previousBalance = indexOfCustomer.getCashBalance();

           indexOfCustomer.setCashBalance( indexOfCustomer.getCashBalance() + CinemaManagementSystem.movieManager.getMovieByIndex(getMovie).getTicketPrice() + customers.get(indexOfCustomer).getHallCharges());
            System.out.println("Your ticket has been refunded!");
            System.out.println("Your new balance is: " + indexOfCustomer.getCashBalance() + " your previous balance was " + previousBalance);
        }
        else {
            System.out.println("Sorry, we couldn't identify you as a valid customer");
        }
    }

    private Customer findCustomer (String customerName) {

        for(Map.Entry<Customer, Hall> map : customers.entrySet()) {
            if(map.getKey().getName().equals(customerName))
              return  map.getKey();
        }
        return null;
    }
    public void rescheduleMovie (String customer, String movie, LocalTime timeOfTheFilm) {
        var indexOfCustomer = findCustomer(customer);
        var getMovie = CinemaManagementSystem.movieManager.findAvailableFilm(movie);

        if(indexOfCustomer != null || getMovie != -1) {
            HashMap<LocalTime, Hall> innerHashMap = new HashMap<>();
            innerHashMap.put(timeOfTheFilm, ConsoleClass.hallPrompt());
            ticketsAvailable.put(innerHashMap, CinemaManagementSystem.movieManager.getMovieByIndex(getMovie));


            System.out.println("Your movie " + CinemaManagementSystem.movieManager.getMovieByIndex(getMovie).getName() + " has been rescheduled to a different timing");
        }
        else {
            System.out.println("Sorry , we couldn't identify you as a valid customer");
        }
    }

}
