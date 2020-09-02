/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS USED TO DEAL WITH THE SEAT ENTITY
 used classes : none
 **/
package HallPackage;
public class Seat {

    /**FIELD DECLARATIONS**/
    private int seatNo;
    private boolean isReserved = false;
    private int seatRow;


    /**OVERLOADED CONSTRUCTORS**/
    Seat(int seatNo, int seatRow, boolean isReserved) {
        this.seatNo = seatNo;
        this.seatRow = seatRow;
        this.isReserved = isReserved;
    }

    Seat(int seatNo,  boolean isReserved) {
        this.seatNo = seatNo;

        this.isReserved = isReserved;
    }

    /**SETTERS**/
    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public void setReservation (boolean value) {
        isReserved = value;
    }

    /**GETTERS**/
    public int getSeatNo() {
        return seatNo;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public boolean getReservation () {
        return isReserved;
    }

}
