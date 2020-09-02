/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS RESPONSIBLE FOR TAKING THE INPUT FROM OUR USER DEPENDING ON THE SCENARIO
 used classes: BookingSystemV2, GenericHall, PremiumV2, StandardHallV2, CinemaManagementSystem, Customer, Movie
               Payment, Hall, StandardHall, PremiumHall
 **/

package UtilityPackage;
import HallPackage.BookingSystemV2;
import HallPackage.GenericHall;
import HallPackage.PremiumHallV2;
import HallPackage.StandardHallV2;
import MainPackage.CinemaManagementSystem;
import MainPackage.Customer;
import MoviePackage.Movie;
import PaymentPackage.Payment;
import PrimitiveClassesPackage.Hall;
import PrimitiveClassesPackage.PremiumHall;
import PrimitiveClassesPackage.StandardHall;

import java.time.LocalTime;
import java.util.Map;
import java.util.Scanner;

public class ConsoleClass {
/**THIS CLASS IS RESPONSIBLE FOR TAKING THE INPUT FROM OUR USER DEPENDING ON THE SCENARIO**/


/**THIS METHOD WILL ENQUIRE OUR USER ABOUT THE FOOD THAT THEY WOULD LIKE TO EAT**/
    public static boolean foodPrompt (Map<String, Double> foodList, Customer customer, Payment payment) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the item that you would like to buy: ");
        String foodName = scan.next();
        while (!(foodList.containsKey(foodName)))
        {
            System.out.println("Please enter a valid item! ");
            foodName = scan.next();
        }
        var result =  payment.pay(customer,foodList.get(foodName));
        return result;
    }

    /**THIS METHOD WILL ASKED THE USER TO INPUT ANY ONE OF THE NUMBERS FROM: 1, 2, 3   AND THEN BASED ON THAT
     * IT WILL RETURN AN INTEGER VALUE TO THE CLASSES THAT IT IS COUPLED TO, AND FROM THERE ON THOSE CLASSES WILL
     * CALL THE APPROPRIATE PAYMENT METHOD
     */
    public static int paymentPrompt () {
        Scanner scan = new Scanner(System.in);
        int paymentMethod;
        System.out.println("Please select a payment method: \n1.Cash Payment \n2.Credit-Card Payment \n3.Cheque Payment");
        paymentMethod = scan.nextInt();
        while (!(paymentMethod == 1 || paymentMethod == 2 || paymentMethod == 3)) {
            System.out.println("Pleas select a valid payment method!");
            paymentMethod = scan.nextInt();
        }
        return paymentMethod;

    }
    /**THIS METHOD WILL ASK OUR USER WHICH FILM WOULD THEY LIKE TO WATCH**/

    public static Movie moviePrompt () {
          Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the film that you're intersted in watching: ");
        String movieName = scan.next();
        var find = CinemaManagementSystem.movieManager.findAvailableFilm(movieName);
        while (find == -1) {
            System.out.println("Please enter a valid movie name: ");
            movieName = scan.next();
            find = CinemaManagementSystem.movieManager.findAvailableFilm(movieName);
        }
       var movieToWatch = CinemaManagementSystem.movieManager.getMovieByIndex(find);
        return movieToWatch;
    }
/**THIS METHOD WILL ENQUIRE OUR USER ABOUT THE SPECIFIED MOVIE TIMINGS**/
    public static LocalTime timingPrompt () {
        Scanner scan = new Scanner(System.in);
        BookingSystemV2.printScheduleTimings();
        System.out.println("Please specify the timing of your film: Answer in Hour number and then the minutes number: ");
        int hours = scan.nextInt();
        int minutes = scan.nextInt();
       var timingOfTheFilm = LocalTime.of(hours, minutes);

       while (!BookingSystemV2.matchShowTimings(timingOfTheFilm)) {
           System.out.println("Please specify A VALID timing of your film: Answer in Hour number and then the minutes number: ");
             hours = scan.nextInt();
             minutes = scan.nextInt();
             timingOfTheFilm = LocalTime.of(hours, minutes);
       }
       return timingOfTheFilm;
    }

    /***NOTE: THIS WAS THE OLD METHOD OF HANDLING THE HALL SYSTEM. IT IS LINKED TO THE BOOKING SYSTEM CLASS, BUT IT DOESN'T SERVE
     * ANY REAL PURPOSE IN THE PROGRAM ANYMORE. I HAVE DECIDED TO LEAVE IT THE WAY IT IS
     * @return
     */
    public static Hall hallPrompt () {
        Scanner scan = new Scanner(System.in);
        Hall preferredHall = null;
        System.out.println("Please specify your preferred hall? Standard or premium");
        String hallName = scan.next();


        while(!(hallName.equalsIgnoreCase("Standard") || hallName.equalsIgnoreCase("Premium"))) {
            System.out.println("Please specify a valid hall!");
            hallName = scan.next();
        }

        if(hallName.equalsIgnoreCase("Standard")) {
              preferredHall = new StandardHall();
        }
        else if (hallName.equalsIgnoreCase("Premium")) {
             preferredHall = new PremiumHall();
        }
         return  preferredHall;
    }




    /**THIS METHOD WILL BOOK THE HALL BASED ON THE USER INPUT**/
    public static GenericHall newHallPrompt () {
        Scanner scan = new Scanner(System.in);
        GenericHall preferredHall = null;
        System.out.println("Please specify your preferred hall? Standard or premium");
        String hallName = scan.next();


        while(!(hallName.equalsIgnoreCase("Standard") || hallName.equalsIgnoreCase("Premium"))) {
            System.out.println("Please specify a valid hall!");
            hallName = scan.next();
        }

        if(hallName.equalsIgnoreCase("Standard")) {
            preferredHall = new StandardHallV2("Standard", 6,140.0);
        }
        else if (hallName.equalsIgnoreCase("Premium")) {
            preferredHall = new PremiumHallV2("Premium", 10, 250.0);
        }
        return  preferredHall;
    }

    /**THIS METHOD WILL GENERATE A NEW CUSTOMER BY ASKING THE USER FOR THE REQUIRED INPUT**/

    public static void newCustomerPrompt (Customer customer) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name: ");
       String name = scan.next();
        System.out.println("Please enter your CNIC number: ");
        String cnic = scan.next();
        System.out.println("Please enter a valid user id for registeration: ");
       String customerId = scan.next();
        System.out.println("Please enter a valid password: ");
       String customerPassword = scan.next();

        System.out.println("Please enter your cash balance: ");
        Double cashBalance = scan.nextDouble();
        System.out.println("Please enter your bank balance: ");
        Double bankBalance = scan.nextDouble();
        System.out.println("Please enter your credit card balance: ");
        Double creditCardBalance = scan.nextDouble();
        System.out.println("Are you a premium member? Answer true or false");
       Boolean isPremium = scan.nextBoolean();

       /**UPDATING THE FIELDS**/
       customer.setName(name);
       customer.setCnic(cnic);
       customer.setCustomerId(customerId);
       customer.setCustomerPassword(customerPassword);
       customer.setCashBalance(cashBalance);
       customer.setBankBalance(bankBalance);
       customer.setCreditCardBalance(creditCardBalance);
       customer.setPremium(isPremium);

        System.out.println("Thank you for your information!");
    }


}
