
/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS IS THE MAIN CLASS IN MY PROGRAM
 used classes : CinemaManagementSystem
 **/
package MainPackage;
import java.io.IOException;
public class Main {
    /**THIS MAIN CLASS IS REPSONSIBLE FOR INTERACTING WITH OUR CINEMA-MANAGEMENT-SYSTEM**/

    public static void main (String args []) throws IOException {
        CinemaManagementSystem cinema = new CinemaManagementSystem();
        cinema.bookFilm();
    }


}
