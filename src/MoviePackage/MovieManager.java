/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS USED TO STORE INFORMATION REGARDING ALL THE MOVIES
 used classes : Movie
 **/
package MoviePackage;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
public class MovieManager implements Serializable {
private ArrayList<Movie> movieList = new ArrayList<>();

    /***THIS CLASS MANAGES OUR MOVIES. IT WILL BE ABLE TO ADD, REMOVE AND PRINT MOVIES. IT WILL ALSO BE ABLE TO PRINT OUT MOVIES BASED
     * ON SPECIFIC PARAMETERS SUCH AS THEIR NAMES
     */


    public MovieManager() {

}
public void add(Movie movie) {
movieList.add(movie);
}

public void addAll (Collection<Movie> collection) {
        movieList.addAll(collection);
}
public void remove(Movie movie) {
    if(!(movieList.contains(movie)))
        throw new IllegalArgumentException("Sorry, the specified movie doesn't exist");
    movieList.remove(movie);
}
public void showUpcoming (){
    for(var movie : movieList) {
        if(movie.getReleaseDate().isAfter(LocalDate.now()))
            System.out.println("Name: " + movie.getName());
        System.out.println("Release date: " + movie.getReleaseDate());
        System.out.println();
    }
}
public void showAvailable () {
    for(var movie : movieList) {
        if(movie.getReleaseDate().isBefore(LocalDate.now()) || movie.getReleaseDate().isEqual(LocalDate.now()))
            System.out.println("Name: " + movie.getName());
        System.out.println("Released on: " +  movie.getReleaseDate());
        System.out.println();
    }
}

public void showAllMovieDetails () {
for(var movie : movieList) {
    System.out.println("Movie name: " + movie.getName());
    System.out.println("Release date: " + movie.getReleaseDate());
    System.out.println("Ratings: " + movie.getRatings());
    System.out.println("Description: " + movie.getDescription());
    System.out.println("Director: " + movie.getDirector());
    System.out.println("MoviePackage.Genre: " + movie.getGenre());
    System.out.println("Budget: " + movie.getMovieBudget());
    System.out.println("Revenue: " + movie.getMovieRevenue());
    System.out.println("Available Status: " + (movie.isAvailableStatus()? "Available": "Not available"));
    System.out.println("Censorship Status: " + (movie.isCensorshipStatus()? "Censored" : "Not censored"));
    System.out.println();
    System.out.println();


}
}


public  int findAvailableFilm (String movieName) {

        int index;
        for(var mov : movieList) {
            if(mov.getName().equalsIgnoreCase(movieName)) {
                return movieList.indexOf(mov);
            }
        }
        return -1;
    }

public Movie getMovieByIndex (int index) {
   return movieList.get(index);
}


public void showMovieDetails () {
//var tempMovie = movieList.indexOf(movie);
    Scanner scan = new Scanner(System.in);
    String movieName;
    System.out.println("Please enter the desired movie name: ");
    movieName = scan.next();

    Movie tempMovie = null;
    boolean found = false;

    for(var mov : movieList) {
        if(mov.getName().equalsIgnoreCase(movieName)) {
            tempMovie = movieList.get(movieList.indexOf(mov));
            found = true;
        }
    }
if(found == true) {
    System.out.println("Movie name: " + tempMovie.getName());
    System.out.println("Release date: " + tempMovie.getReleaseDate());
    System.out.println("Ratings: " + tempMovie.getRatings());
    System.out.println("Description: " + tempMovie.getDescription());
    System.out.println("Director: " + tempMovie.getDirector());
    System.out.println("MoviePackage.Genre: " + tempMovie.getGenre());
    System.out.println("Budget: " + tempMovie.getMovieBudget());
    System.out.println("Revenue: " + tempMovie.getMovieRevenue());
    System.out.println("Available Status: " +(tempMovie.isAvailableStatus() ? "Available" : "Not available"));
    System.out.println("Censorship Status: " + (tempMovie.isCensorshipStatus() ? "Censored" : "Not censored"));
}

}



public  int findAvailableFilm () {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter the desired movie name: ");
    String movieName = scan.next();

    int index;
    for(var mov : movieList) {
        if(mov.getName().equalsIgnoreCase(movieName)) {
            return movieList.indexOf(mov);
        }
    }
    return -1;
}




public MoviePackage.Movie getMovie (String name) {
    for(var mov : movieList) {
        if(mov.getName().equalsIgnoreCase(name)) {
            return mov;
        }
    }
    return null;
}



}
