
/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS IS THE CLASS WHERE CUSTOMER, MOVIE, AND THE HALL TYPE INTERSECT WITH EACH OTHER
 used classes : Customer, Movie, GenericHall
 **/

package HallPackage;
import HallPackage.GenericHall;
import MainPackage.Customer;
import MoviePackage.Movie;


public class Ticket {
    /**THIS IS THE CLASS WHERE CUSTOMER, MOVIE, AND THE HALL TYPE INTERSECT WITH EACH OTHER
     * WHENVER THE USER PURCHASES A FILM, A TICKET WILL BE GENERATED. THIS TICKET IS IMPORTANT SO THAT I MAY
     * BE ABLE TO KEEP A TRACK OF THE CUSTOMERS WHO PURHCASED THE FILM
     */

/**FIELD DECLARATIONS**/
     private Customer ticket;
     private Movie movie;
    private GenericHall hall;


    Ticket (Customer customer, Movie movie, GenericHall hall) {
        this.ticket = customer;
        this.movie = movie;
        this.hall = hall;

    }


    /**GETTERS**/
    public Movie getMovie() {
        return movie;
    }

    public GenericHall getHall() {
        return hall;
    }

    public Customer getTicket() {
        return ticket;
    }

    /**SETTERS**/
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setHall(GenericHall hall) {
        this.hall = hall;
    }


    public void setTicket(Customer ticket) {
        this.ticket = ticket;
    }

}
