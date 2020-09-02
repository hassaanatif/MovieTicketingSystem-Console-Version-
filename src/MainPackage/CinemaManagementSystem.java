 /**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
  Description: THIS CLASS IS RESPONSIBLE FOR MANAGING ALL THE FEATURES OF THE CINEMA
  used classes :  Beverages, FastFood, FoodManager, Snacks, BookingSystemV2, Genre, Movie, MovieManager, CashPayment,
                  CreidtCardPayment, ConsoleCLass
  **/
 package MainPackage;

import FeedbackPackage.Report;
import FoodPackage.Beverages;
import FoodPackage.FastFood;
import FoodPackage.FoodManager;
import FoodPackage.Snacks;
import HallPackage.BookingSystemV2;
import MoviePackage.MovieManager;
import PaymentPackage.CashPayment;
import PaymentPackage.ChequePayment;
import PaymentPackage.CreditCardPayment;
import UtilityPackage.ConsoleClass;
import UtilityPackage.InputOutputClass;

import java.io.IOException;
import java.util.*;

/***I initially had the prototype for this project ready within the first 3 days of starting out with it.
 * Throughout that time, it has been a constant series of iterations (pun intended) to perfect it in whatever way
 * I can. I would also like to state, during the development, I had a clash with the GUI version of this project as well
 * So to find a middle ground, I put just as much emphasis on each of these projects as I could.
 */

/***SOME INFORMATION ABOUT THIS PROGRAM AND WHAT IT OFFERS:
 * This is supposed to be a sort of MainPackage.CinemaManagementSystem, but it has been designed specifically for the customers, and
 * not for the administrators. Here are some of the features that my program offers:
 * (i) You can create a new account and login into, even after the application has been closed. But the only limitation is that
 * the program will only remember the last account that was created.
 * (ii) You can book seats in two types of halls: a) Standard PrimitiveClassesPackage.Hall  b) Premium PrimitiveClassesPackage.Hall
 *      the main contrast between both these halls is the number of seats that each of these halls have to offer
 * (iii) When the seat count in a *particular* hall for a *particular* movie reaches to zero, you won't be able to book tickets
 * in that specific hall
 * (iv) You can make your purchase through credit card, bank/cheque or through your cash balance
 * (v) Your user data will remained saved even after the program has been ended. Though the consumption of halls will not be
 *    saved.
 */

/***CREATED AND DOCUMENTED (On 8/22/20) ENTIRELY BY HASSAAN ATIF
 * My socials:
 * hassaanatif@gmail.com
 * artstation/hassaanatif
 * youtube/c/HassaanAtif
 */






public class CinemaManagementSystem {


 /**FIELD DECLARATIONS**/
public  static MovieManager movieManager = new MovieManager();
private LoginServer server = new LoginServer();
private Scanner scan =  new Scanner(System.in);

    /**This is the depcreated version of my bookingSystem. While it worked greatly, but it had it's flaws. There was a lot
     * of potential to derive separate entities from this class. For that reason, I created an entirely new class (more on that later)
     * and a bunch of other classes and made them intersect using a properly defined entity model relationship
     */
//private PrimitiveClassesPackage.BookingSystem bookingSystem = new PrimitiveClassesPackage.BookingSystem();


private FoodManager foodManager;
private Report report = new Report();

/**This is the new booking class that I am using. It is much more efficient, and has much more defined model**/
private BookingSystemV2 bookingSystemV2 = new BookingSystemV2();


/**CONSTRUCTOR**/
    CinemaManagementSystem() throws IOException {
        initialize();
    }



/***This method is responsible for initializing all the things in my cinema system**/
    public  void initialize () throws IOException {
        initializeMovies();

        //menu choice variable here will ask our user to select any one of the given options
        int menuChoice;
        System.out.println("Welcome to Grand Merriate Cinemas, please select any one of the following options: \n1.Login account \n2.Register new account");
        menuChoice = scan.nextInt();
        loginScreen(scan, menuChoice);


        /**after our user has proceeded past the login screen, then my program prints out all the available features
         * and then transfers the control the menu section
         */
        System.out.println("Welcome to our menu. Please select any of the following: \n1.List all the available films \n2.List the details of a particular film \n3.Book a film \n4.Refund a film \n5.Reschedule film \n6.Print FoodPackage.Snacks \n7.Print Fast Food \n8. Print FoodPackage.Beverages");
        System.out.println("9. Buy FoodPackage.Snacks \n10.Buy FoodPackage.Beverages \n11. buy Fast food \n12.Show upcoming films \n13.Show All Movies details \n14. Give feedback  \n15. Account details");
        menuChoice = scan.nextInt();

        Menu(scan, menuChoice);





    }

    private void initializeMovies()  {


        /***PRIOR APPROACH OF ADDING FILMS (MANUAL METHOD)**/
        /*   Movie movie1 = new Movie("Uncharted", LocalDate.of(2020, 7, 20), "Great film", Genre.Action, 5, true, false, 2000.0, 1000.0,"Arthour", 20.0);
            Movie movie2 = new Movie("Titanic", LocalDate.of(2000, 4, 10), "Great film", Genre.Action, 5, true, false, 2000.0, 1000.0,"James", 35.5);
            Movie movie3 = new Movie("Django", LocalDate.of(1999, 7, 25), "Great film", Genre.Action, 5, true, false, 2000.0, 1000.0,"Kendall", 23.0);
            Movie movie4 = new Movie("Inherited", LocalDate.of(1995, 3, 16), "Great film", Genre.Action, 5, true, false, 2000.0, 1000.0,"Jonathan", 30.0);
            Movie movie5 = new Movie("Mummy", LocalDate.of(2021, 9, 19), "Great film", Genre.Action, 5, true, false, 2000.0, 1000.0,"Gunn", 50.0);

            movieManager.add(movie1);
            movieManager.add(movie2);
            movieManager.add(movie3);
            movieManager.add(movie4);
            movieManager.add(movie5);*/

        /***UPDATE:
         * I have now written all of my movie data through file handling
         */

        /**Running in a separate thread**/


        Thread thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 try {
                     movieManager = InputOutputClass.readMovies();
                 }
                 catch (Exception e) {
                     System.out.println("Ooops! We've encountered an error while initializing your films :(");
                 }
             }
         });
         thread.run();




    }


    /**LOGIN/REGISTER/MENU METHODS**/
    private void loginScreen (Scanner scan, int menuChoice) throws IOException {
        boolean flagChecker = true;
        while (flagChecker) {
            switch (menuChoice) {
                case 1:
                   if(Login()) {
                       flagChecker = false;
                    }
                    break;
                case 2:
                    register();
                    break;
                default:
                    System.out.println("Pleas select a valid option!");
                    break;
            }
            if(!flagChecker)
                break;
            System.out.println("What would you like to do next?");
            menuChoice = scan.nextInt();
         }

    }

    /**This function consists of all the features in my program**/

    private void Menu(Scanner scan, int menuChoice) throws IOException {

        while (menuChoice < 16) {
            switch (menuChoice) {
                case 1 -> showAvailableFilms();
                case 2 -> showMovieDetails();
                case 3 -> bookFilm();
                case 4 -> refundFilm();
                case 5 -> rescheduleFilm();
                case 6 -> printAvailableSnacks();
                case 7 -> printAvailableFastFood();
                case 8 -> printAvailableBeverages();
                case 9 -> buySnack();
                case 10 -> buyBeverage();
                case 11 -> buyFastFood();
                case 12 -> showUpcoming();
                case 13 -> showAllMovieDetails();
                case 14 -> reportFeedBack();
                case 15 -> LoginServer.currentUser.getDetails();
                default -> System.out.println("Oops wrong input!");
            }
            System.out.println("What would you like to do next?");
            menuChoice = scan.nextInt();

        }
    }

    private void reportFeedBack() {
        Scanner sc = new Scanner(System.in);
        String tempFeedback;
        System.out.print("Do you have any feedback that you'd like to share?");
        tempFeedback = sc.nextLine();
        report.reportFeedback(LoginServer.currentUser, tempFeedback);
    }


    /**LOGIN/REGISTER SCREEN COMPONENTS**/

    public   void register() throws IOException {
        server.newLogin();
    }

    public boolean Login() throws IOException {
      return  server.matchLogin();

     }




     /**MoviePackage.Movie Maanger Methods**/

     public   void showAvailableFilms () {
         movieManager.showAvailable();
     }
     public   void showUpcoming () {
        movieManager.showUpcoming();
     }
     public   void showAllMovieDetails () {
        movieManager.showAllMovieDetails();
     }
     public   void showMovieDetails () {

        movieManager.showMovieDetails();
     }


     /**BOOKING METHODS**/
     public   void bookFilm () {
         Customer customer;
         if(LoginServer.currentUser == null) {
             customer = Customer.createNew();
         }
         else {
             customer = LoginServer.currentUser;
         }
         var paymentMethod = ConsoleClass.paymentPrompt();

         /**I HAVE COMMENTATED OUT THE OLD WAYS THAT I WAS USING TO BOOK MY TICKETS SINCE THEY WERE NOT EFFICIENT**/

   /*   if(paymentMethod == 1) {
          bookingSystem.bookMovie(customer,UtilityPackage.ConsoleClass.moviePrompt(), UtilityPackage.ConsoleClass.timingPrompt(), UtilityPackage.ConsoleClass.hallPrompt(), new PaymentPackage.CashPayment());

      }
      else if (paymentMethod == 2) {
          bookingSystem.bookMovie(customer, UtilityPackage.ConsoleClass.moviePrompt(), UtilityPackage.ConsoleClass.timingPrompt(), UtilityPackage.ConsoleClass.hallPrompt(), new PaymentPackage.CreditCardPayment());

      }
      else if (paymentMethod == 3) {
          bookingSystem.bookMovie(customer, UtilityPackage.ConsoleClass.moviePrompt(), UtilityPackage.ConsoleClass.timingPrompt(), UtilityPackage.ConsoleClass.hallPrompt(), new PaymentPackage.ChequePayment());

      }*/


      if(paymentMethod == 1) {
          bookingSystemV2.bookMovie(customer, ConsoleClass.moviePrompt(),   ConsoleClass.newHallPrompt(), new CashPayment());
      }
      else if (paymentMethod == 2) {
          bookingSystemV2.bookMovie(customer, ConsoleClass.moviePrompt(),  ConsoleClass.newHallPrompt(), new CreditCardPayment());

      }
      else if (paymentMethod == 3) {
          bookingSystemV2.bookMovie(customer, ConsoleClass.moviePrompt(),  ConsoleClass.newHallPrompt(), new ChequePayment());

      }




     }

     public void refundFilm () {
         System.out.println("Please enter your name: ");
         String customerName = scan.next();
         System.out.println("Please enter the name of the film that you would like refund: ");
         String movieName = scan.next();

         /**The old method has been commentated out**/
      //   bookingSystem.refundMovie(customerName, movieName);
         bookingSystemV2.refundMovie(customerName, movieName);


     }

     public   void rescheduleFilm () {
         System.out.println("Please enter your name: ");
         String customerName = scan.next();
         System.out.println("Please enter the name of the film that you would like to reschedule: ");
         String movieName = scan.next();

         /**Once again, the method has been commentated out**/
       /*  System.out.println("Please enter your new timing in the format: hour and then minutes: ");
         int hour = scan.nextInt();
         int minutes = scan.nextInt();
         bookingSystem.rescheduleMovie(customerName,movieName, LocalTime.of(hour, minutes));*/

         bookingSystemV2.rescheduleMovie(customerName, movieName);
     }

    /***FOOD PORTION**/
    public   void printAvailableSnacks() {
        foodManager = new Snacks();
        foodManager.printAvailableItems();
    }

    public   void printAvailableFastFood () {
        foodManager = new FastFood();

        foodManager.printAvailableItems();
    }

    public void printAvailableBeverages () {
        foodManager = new Beverages();
        foodManager.printAvailableItems();
    }

    public void buyBeverage () throws IOException {
        foodManager = new Beverages();
        Customer customer;
       if(LoginServer.currentUser == null) {
           customer = Customer.createNew();
       }
       else {
           customer = LoginServer.currentUser;
       }
        callAppropriateBuyMethod(foodManager, customer);



    }


    public void buySnack () throws IOException {
        foodManager = new Snacks();
        Customer customer;
        if(LoginServer.currentUser == null) {
            customer = Customer.createNew();
        }
        else {
            customer = LoginServer.currentUser;
        }
        callAppropriateBuyMethod(foodManager, customer);

    }

    public void buyFastFood() throws IOException {
        foodManager = new FastFood();
        Customer customer;
        if(LoginServer.currentUser == null) {
            customer = Customer.createNew();
        }
        else {
            customer = LoginServer.currentUser;
        }
        callAppropriateBuyMethod(foodManager, customer);

    }

    /**SINCE I HAVE THREE SEPARATE IMPLEMENTATIONS OF MY FOOD INTERFACE, THEREFORE IN THIS CLASS, I HAVE
     * DECIDED TO EXTRACT A METHOD THAT WILL TAKE THE USER INPUT AND DECIDE WHICH PAYMENT METHOD TO CALL
     * USING MY FOOD INTERFACE
     */

    public void callAppropriateBuyMethod (FoodManager foodManager, Customer customer) throws IOException {
        var paymentMethod = ConsoleClass.paymentPrompt();

        if(paymentMethod == 1) {
            foodManager.buy(new CashPayment(), customer);
        }
        else if (paymentMethod == 2) {
            foodManager.buy(new CreditCardPayment(), customer);
        }
        else if (paymentMethod == 3) {
            foodManager.buy(new ChequePayment(), customer);
        }
    }





}
