package FeedbackPackage; /**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS  IS RESPONSIBLE FOR KEEPING A TRACK OF THE USER FEEDBACK
 used classes: Customer
 **/
import MainPackage.Customer;

import java.util.HashMap;


public class Report {
/**THIS CLASS  IS RESPONSIBLE FOR KEEPING A TRACK OF THE USER FEEDBACK**/

    HashMap<String, Customer> reports = new HashMap<>();

    public void reportFeedback(Customer customer, String report) {
        reports.put(report, customer);
        System.out.println("Thank you for feedback, we'll work on the things that you have mentioned");
    }
}
