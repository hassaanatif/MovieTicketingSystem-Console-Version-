/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS DEALS WITH THE HALLS FUNCTIONALITY
 used classes : Seat
 **/


package HallPackage;
public abstract class GenericHall {
    /***NOTE: THIS IS THE NEW HALL CLASS. THE PREVIOUS HALL CLASS WAS LINKED TO THE PREVIOUS BOOKING SYSTEM, SO I HAD
     * DECIDED TO CREATE AN ENTIRELY NEW ABSTRACT HALL CLASS WITH TWO EXTENSIONS: A)  "HallPackage.StandardHallV2"
     * B) "HallPackage.PremiumHallV2"
     *
     */

    /***FIELD DECLARATIONS**/

    /**I AM SETTING THIS AS PROTECTED SO THAT MY CHILD CLASSES MAY BE ABLE TO ACCESS THIS ELEMENT**/
    protected int numberOfSeats;

    private Seat[] seats;
    private Double hallPrice;
    private String title;


    GenericHall (String title,   int numberOfSeats, Double hallPrice) {
        this.numberOfSeats = numberOfSeats;
        seats = new Seat[numberOfSeats];

        initializeSeats();

        this.title = title;
        this.hallPrice = hallPrice;


    }

    protected  void initializeSeats() {
         for(int i = 0; i<seats.length; i++) {
             seats[i] = new Seat(i,false);
         }
    }


    public boolean updateNumberOfSeats(int numberOfSeats) {
        if(!(numberOfSeats < 0)) {
            this.numberOfSeats = numberOfSeats;
            return true;
        }
       return false;

    }

    /**SETTERS**/
    public void setTitle(String title) {
        this.title = title;
    }

    public void setHallPrice(Double hallPrice) {
        this.hallPrice = hallPrice;
    }
    /**GETTERS**/

    public int getNumberOfSeats() {
        return numberOfSeats;
    }


    public String getTitle() {
        return title;
    }

    public Double getHallPrice() {
        return hallPrice;
    }




}
