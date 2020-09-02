
/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS RESPONSIBLE FOR KEEPING A LIST OF SHOWS THAT ARE CURRENTLY AVAILABLE
 used classes: Show
 **/
package HallPackage;
import java.util.ArrayList;
public class Schedule {
    /**THIS CLASS IS RESPONSIBLE FOR KEEPING A LIST OF SHOWS THAT ARE CURRENTLY AVAILABLE**/


    /**FIELD DELCARATION**/
    private ArrayList<Show> shows = new ArrayList<>();



    public void addShow (Show show) {
        shows.add(show);
    }
    public void removeShow (Show show) {
        shows.remove(show);
    }

    public boolean containsShow (Show show) {
        for( var a : shows) {
            if(show.getMovie().getName().equals(a.getMovie().getName()) && show.getTime().equals(a.getTime()) ) {
                return true;
            }
        }
        return false;
    }


/**GETTERS**/
    public Show getShowByIndex (int index) {
        if(index != -1 && index < shows.size())
            return shows.get(index);
        return null;
    }

    public ArrayList<Show> getShows () {
        return shows;
    }

    public Show getSpecificShow (Show show) {
        for( var a : shows) {
            if(a.getMovie().getName().equals(show.getMovie().getName()) && a.getTime().equals(show.getTime()) ) {
                return a;
            }
        }
        return null;
    }
}
