/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS CURRENTLY NOT IN USE
 used classes: Customer
 **/
package PromotionPackage;

import MainPackage.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Coupon extends Promotion {
    private List<Integer> coupons = new ArrayList<>();
     private String description;


    @Override
    public void add(int code) {
        coupons.add(code);
    }

    @Override
    public void remove(int code) {
     coupons.remove(code);
    }

    @Override
    public void setDescription(String description) {
     this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void avail(int voucherCode, Customer customer) {
        Random random = new Random();
        int rand = random.nextInt()%90;
        if(coupons.contains(voucherCode)) {
            System.out.println("Congrats you have availed your coupon code that allots you a discount of: " + coupons.get(rand) + "%");
        }
        else {
            System.out.println("Sorry, the code that you entered doesn't exist");
        }
    }
}
