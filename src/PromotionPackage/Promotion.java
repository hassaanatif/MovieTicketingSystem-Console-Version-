/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS DEALS WITH THE PROMOTIONS
 used classes: Customer
 **/
package PromotionPackage;

import MainPackage.Customer;



public abstract class Promotion {
public  void add(int code) {};
public  void remove (int code){};
public abstract  void setDescription (String description);
public abstract String getDescription ();
public abstract void avail (int voucherCode, Customer customer);

}
