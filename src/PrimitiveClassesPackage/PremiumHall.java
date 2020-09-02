/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS NO LONGER IN USE
 used classes: none
 **/
package PrimitiveClassesPackage;

public class PremiumHall extends  Hall {
    /***THIS CLASS IS NO LONGER IN USE**/



   private String title;
   private int numberOfSeats;
   private String description;
    private double charges;
    private boolean isGoldPremium;

    public PremiumHall() {
        setTitle("Standard PrimitiveClassesPackage.Hall");
        setNumberOfSeats(10);
        setDescription("Welcome to the standard PrimitiveClassesPackage.Hall");
        setHallCharges(200.0);
    }


/***OVERRIDEN METHODS**/
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

    /**OTHER METHODS**/
    public void setIsGoldPremium (boolean isGoldPremium) {
       this.isGoldPremium = isGoldPremium;
    }

    public boolean getIsPremium (){
        return isGoldPremium;
    }

}
