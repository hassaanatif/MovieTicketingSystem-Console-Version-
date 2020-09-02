/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS DEALS WITH THE MOVIE ENTITY
 used classes : none
 **/
package MoviePackage;

import java.io.Serializable;
import java.time.LocalDate;

public class Movie implements Serializable {
    /**FIELD DECLARATIONS**/
    private String name;
    private LocalDate releaseDate;
    private  String description;
    private Genre genre;
    private int ratings;
    private boolean availableStatus;
    private boolean censorshipStatus;
    private double MovieRevenue;
    private double movieBudget;
    private String director;

    /**new addition**/
    private double ticketPrice;


    public Movie(String name, LocalDate releaseDate, String description, Genre genre, int ratings, boolean availableStatus, boolean censorshipStatus, double movieRevenue, double movieBudget, String director, double ticketPrice) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.description = description;
        this.genre = genre;
        this.ratings = ratings;
        this.availableStatus = availableStatus;
        this.censorshipStatus = censorshipStatus;
        MovieRevenue = movieRevenue;
        this.movieBudget = movieBudget;
        this.director = director;
        this.ticketPrice = ticketPrice;
    }

    public boolean isAvailableStatus() {
        return availableStatus;
    }

    public boolean isCensorshipStatus() {
        return censorshipStatus;
    }



    /**GETTERS**/
    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getDirector() {
        return director;
    }

    public String getName() {
        return name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getRatings() {
        return ratings;
    }

    public double getMovieRevenue() {
        return MovieRevenue;
    }
    public double getMovieBudget() {
        return movieBudget;
    }

 /**SETTERS**/
    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public void setAvailableStatus(boolean availableStatus) {
        this.availableStatus = availableStatus;
    }

    public void setCensorshipStatus(boolean censorshipStatus) {
        this.censorshipStatus = censorshipStatus;
    }

    public void setMovieRevenue(Double movieRevenue) {
        MovieRevenue = movieRevenue;
    }

    public void setMovieBudget(Double movieBudget) {
        this.movieBudget = movieBudget;
    }

    public void setDirector(String director) {
        this.director = director;
    }


}
