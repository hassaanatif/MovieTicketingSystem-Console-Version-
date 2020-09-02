 /**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS DEALS WITH THE BOOKINGS
  used classes : Customer, LoginServer, Movie, Payment, ConsoleClass, InputOutputClass
 **/
 package HallPackage;
import MainPackage.Customer;
import MainPackage.LoginServer;
import MoviePackage.Movie;
import PaymentPackage.Payment;
import UtilityPackage.ConsoleClass;
import UtilityPackage.InputOutputClass;

import java.time.LocalTime;
import java.util.ArrayList;

/***This  is the new version of my PrimitiveClassesPackage.BookingSystem class that is much more flexible. Here's what's different here:
 * Instead of using nested hashmaps as I did in my previous bookingSystem class, I have decided to derive a bunch of separate entities
 * and then I made those entities intersect in a single class called "schedule". The good thing about this is that total number of seats will
 * be changed on the basis of their local time
 */
public class BookingSystemV2 {

    /**FIELD DECLARATIONS**/
    public static Schedule schedule = new Schedule();
    private ArrayList<Ticket> ticketBox = new ArrayList<>();
    private static ArrayList<LocalTime> validTimings = new ArrayList<>();


    public BookingSystemV2() {
        /**Adding a list of valid timings to our booking system**/
        validTimings.add(LocalTime.of(3,30));
        validTimings.add(LocalTime.of(5,45));
        validTimings.add(LocalTime.of(6,15));

    }

    public void bookMovie (Customer customer, Movie movie, GenericHall hallType, Payment payment) {



        /**We are creating a ticket entity here that will store the customer info along wit the film that he decided to watch and the hall
         * -type that he went for
         */
         Ticket ticket = new Ticket(customer, movie, hallType);
         /**I am assigning them values through setters to be absolute certain that they're assigned values**/
         ticket.setHall(hallType);
         ticket.setMovie(movie);
         ticket.setTicket(customer);


        /**retrieving the time that our user wants to view the film**/
        LocalTime timeOfTheFilm = ConsoleClass.timingPrompt();


        Show show1 = new Show(hallType, movie, timeOfTheFilm);



        /***These next two methods will check to see if our schedule already contains the shows that we have
         * made instances of above. It it doesn't contain so, then we'll add it to our schedule. The comparions
         * is based on the MovieTimings (or LocalTime).
         */
        if(!(schedule.containsShow(show1))) {
            System.out.println("new show added!!!");
            schedule.addShow(show1);
        }


        /**FINALLY DEALING WITH BOOKING**/

        if (payment.pay(hallType.getHallPrice())) {
            var numberOfSeats = schedule.getSpecificShow(show1).getGenericHall().getNumberOfSeats();
            /**retrieving our show**/
            if(schedule.getSpecificShow(show1).getGenericHall().updateNumberOfSeats(numberOfSeats -1)) {

                ticketBox.add(ticket);
                System.out.println("HallPackage.Ticket has been successfully booked!");
                System.out.println("Also total number of seats left: " + schedule.getSpecificShow(show1).getGenericHall().getNumberOfSeats());
            }
            else {
                System.out.println("Sorry the seats are the full for this show!");
            }
            }
        else {
            System.out.println("Sorry insufficient balance!");
        }

    }

    public void refundMovie (String customer, String movietoRefund) {

        /***Finding out if the matched customer exists in our ticketBox**/
   for (var a : ticketBox) {
            if(a.getTicket().getName().equals(customer) && a.getMovie().getName().equals(movietoRefund)) {

              var ticketPrice =  a.getMovie().getTicketPrice();
               var hallPrice = a.getHall().getHallPrice();
               LoginServer.currentUser.setCashBalance(LoginServer.currentUser.getCashBalance() + ticketPrice + hallPrice);

                System.out.println("An amount of " + ticketPrice + " and " + hallPrice + " from your ticket and hall seat purchase of the film " +
                        a.getMovie().getName() + " has been successfully refunded to your cash amount");
               try {
                   InputOutputClass.writeUser(LoginServer.usersList);
               }
               catch (Exception e) {
                   e.printStackTrace();
               }

               }
        }



    }

    /**I am going to need this for our console class for data validation**/
    public static void printScheduleTimings () {
        System.out.println("HallPackage.Show timings: ");
        for(int i = 0; i<validTimings.size(); i++) {
            System.out.println(validTimings.get(i));
        }
        System.out.println();


    }

    /**Once again, this class is used in the console class to match the our given timings in the arraylist here
     * This is to make sure that the user doesn't enter any wrong timings
     */
    public static boolean matchShowTimings (LocalTime time) {
        for(int i = 0; i<validTimings.size(); i++) {
            if (validTimings.get(i).equals(time)) {
                return true;
            }
        }
     return false;
    }



    public void rescheduleMovie (String customer, String movie){
        LocalTime timeOfTheFilm = ConsoleClass.timingPrompt();
        for (var a : ticketBox) {
            if(a.getTicket().getName().equals(customer) && a.getMovie().getName().equals(movie)) {
                Show show1 = new Show(a.getHall(), a.getMovie(), timeOfTheFilm);
                if(!schedule.containsShow(show1)) {
                    schedule.addShow(show1);
                }
                    System.out.println("Your movie " + movie + " was successfully scheduled to a different timing");
                    try {
                        InputOutputClass.writeUser(LoginServer.usersList);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }

            }
        System.out.println("Sorry, there was a problem while rescheduling your film :(");
    }

    }

