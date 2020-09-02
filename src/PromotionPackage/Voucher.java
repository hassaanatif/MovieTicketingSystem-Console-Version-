/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS IS CURRENTLY NOT IN USE
 used classes: Customer
 **/
package PromotionPackage;


import MainPackage.Customer;
import PromotionPackage.Promotion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Voucher extends Promotion {
    /**THIS CLASS IS 'CURRENTLY' NO IN USE**/

    /**FIELD DECLARATIONS**/
    private HashSet<Integer> availableCodes = new HashSet<>();
     private List<String> availablePrizes = new ArrayList<>();

    private String description;


    public void avail (int voucherCode, Customer customer) {
        Random random = new Random();
        int rand = random.nextInt()%5;
        if(availableCodes.contains(voucherCode)) {
            System.out.println("Congrats you have just won yourself : " + availablePrizes.get(rand));
        }
        else {
            System.out.println("Sorry, the code that you entered doesn't exist");
        }
    }

    public void add (int voucherCode) {
        availableCodes.add(voucherCode);
    }

    public void remove (int voucherCode) {
        availableCodes.remove(voucherCode);
    }

    /**GETTERS**/
    public String getDescription() {
        return description;
    }
    /**SETTERS**/
    public void setDescription(String description) {
        this.description = description;
    }


}
