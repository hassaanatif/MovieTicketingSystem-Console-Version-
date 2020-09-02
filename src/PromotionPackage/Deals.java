/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS CURRENTLY NOT IN USE, BUT IT WAS SUPPOSED TO HANDLE THE DEALING SYSTEM IN THE CINEMA
 used classes: Customer
 **/
package PromotionPackage;

import MainPackage.Customer;



public class Deals extends Promotion{
/**THIS CLASS IS CURRENTLY NOT IN USE, BUT IT'S INITIAL PURPOSE WAS TO HANDLE OUR DEALS FOR THE CUSTOMERS**/
    private String description;
    @Override
    public void setDescription(String description) {
       this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void avail(int dealCode, Customer customer) {

    }
}
