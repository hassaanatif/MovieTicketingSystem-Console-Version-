 /**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS DEALS WITH THE LOGIN/SIGN-UP FUNCTIONALITY
  used classes : InputOutputClass
 **/
 package MainPackage;
import UtilityPackage.InputOutputClass;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class LoginServer implements Serializable {

    /***Declaring our fields8*/
    /***loginDetails will store the login info of our user, while the
     * - userList will store the customer information it.
     */
   private HashMap<String, String> loginDetails = new HashMap<>();
   public static List<Customer> usersList = new ArrayList<>();

   /**This field is current not in use, so it doesn't really serve any real purpose here**/
   private static int totalUsers;

   /**This will hold our currentUser (customer) in the program**/
    public static Customer currentUser;

    private Scanner scan = new Scanner(System.in);



    LoginServer () {


    }


    /**Whenever our user would like to create a new account, the account information will get stored
     * in the loginDetails HashMap while the customerList will be updated by adding this new user to our
     * customer list
     * @throws IOException
     */
    public void newLogin () throws IOException {
        var customer = Customer.createNew();

        loginDetails.put(customer.getCustomerId(), customer.getCustomerPassword());
        usersList.add(customer);

        InputOutputClass.writeLogin(loginDetails);
        InputOutputClass.writeUser(usersList);

        System.out.println("Successfully Registered! You must log into your account now!");
        totalUsers++;
    }


    /**This method currently does not serve any real purpose here, so I have commentated it. I would like to
     * access my static member directly through the class name
     */
/*    public static MainPackage.Customer getCurrentUser () {
         if(getCurrentUser() != null)
             return currentUser;
         return null;
    }*/


    /**This will iterate through the usersList and return us our current user from the list**/
    private Customer findCurrentUser(String id) {
        for(var c : usersList) {
            if(c.getCustomerId().equals(id))
                return c;
        }
        return null;
    }


    /**This method is used to sign into our acount**/
    public boolean matchLogin () throws IOException {

        HashMap<String, String> tempMap = new HashMap<>();
        if (InputOutputClass.readLogin() != null) {
            tempMap = InputOutputClass.readLogin();
            loginDetails.putAll(tempMap);
        }

        /**importing our customer's data**/


        if (InputOutputClass.readUser() != null) {
            List<Customer> tempCustomer = new ArrayList<>();
            tempCustomer = InputOutputClass.readUser();
            usersList.addAll(tempCustomer);
        }

     //   while (true) {
            System.out.println("Please enter a correct user id for login: ");
            String tempId = scan.next();

            System.out.println("Please enter a valid password");
            String tempPass = scan.next();

            if (validateUser(tempId, tempPass)) {
                System.out.println("Login Successful!");
                System.out.println("Welcome to your account " + tempId);
                currentUser = findCurrentUser(tempId);
                return true;
            }
            else {
                System.out.println("Sorry, the information that you have entered is incorrect");
            }

       // }
        return false;
    }

    /**This will check the validity of our login info**/
    private boolean validateUser(String tempId, String tempPass) {
        return loginDetails.containsKey(tempId) && loginDetails.get(tempId).equals(tempPass);
    }



/*    public boolean userCheck (String customerId, String password) {
        for(var user : usersList) {
            if(user.getCustomerId().equals(customerId) && user.getCustomerPassword().equals(password))
                return true;
        }
        return false;
    }*/



}
