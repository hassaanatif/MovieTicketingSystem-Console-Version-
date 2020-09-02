/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS NO LONGER IN USE
 used classes: none
 **/
package PrimitiveClassesPackage;

public class StandardHall  extends  Hall{
    /***THIS CLASS IS NO LONGER IN USE AND HAS BEEN REPLACED BY THE NEW CLASS "HallPackage.StandardHallV2"***/


    private String title;
    private int numberOfSeats;
    private String description;
    private double charges;

    public StandardHall() {
        setTitle("Standard PrimitiveClassesPackage.Hall");
        setNumberOfSeats(10);
        setDescription("Welcome to the standard PrimitiveClassesPackage.Hall");
        setHallCharges(0.0);

    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setHallCharges(double charges) {
        this.charges = charges;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Double getHallCharges() {
        return charges;
    }
}
