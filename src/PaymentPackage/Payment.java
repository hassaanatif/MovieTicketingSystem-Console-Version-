/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS RESPONSIBLE FOR THE PAYMENT SYSTEM
 used classes : Customer,  Movie, Hall

 **/

package PaymentPackage;

import MainPackage.Customer;
import MoviePackage.Movie;
import PrimitiveClassesPackage.Hall;

/**NOTE: I DEFINITELY SHOULD HAVE USED AN INTERFACE HERE, SINCE ABSTRACT CLASSES SHOULD ONLY BE USED WHEN THERE IS SOME
 * FORM OF DEFAULT IMPLEMENTATION INVOLVED
 */
public abstract  class Payment {
    public abstract boolean pay(Customer customer, Movie movie);
    public abstract boolean pay(Double hallPrice);
    public abstract boolean pay(Customer customer, Hall hall);

    public abstract boolean pay (Customer customer, double price);
}
