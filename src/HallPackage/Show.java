/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS USED TO HANDLE THE SHOW ENTITY. THIS IS WHERE MOVIE, HALL AND MOVIE TIMINGS INTERSECT
 used classes :  Movie
 **/
package HallPackage;
import HallPackage.GenericHall;
import MoviePackage.Movie;

import java.time.LocalTime;
public class Show {
/**THIS IS THE CLASS WHERE MOVIE, HALL AND THE MOVIE TIMINGS WILL INTERSECT**/


/**FIELD DECLARATIONS**/
    private GenericHall genericHall;
    private Movie movie;
    private LocalTime time;




    public Show(GenericHall hall, Movie movie, LocalTime time) {
        this.genericHall = hall;
        this.movie = movie;

        this.time = time;

    }




    /**GETTERS**/
    public GenericHall getGenericHall() {
        return genericHall;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getShowId() {
        return showId;
    }



    /**SETTERS**/
    public void setShowId(int showId) {
        this.showId = showId;
    }
    public void setGenericHall(GenericHall genericHall) {
        this.genericHall = genericHall;
    }
    private int showId;
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
}
