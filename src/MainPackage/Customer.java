/**Project name : Melite-Meu (MovieTicketingSystem)
 Roll no:  0147-BSCS-2019 (Section C)
 Description: THIS CLASS IS RESPONSIBLE FOR DEALING WITH OUR CUSTOMER/USER
 used classes : ConsoleClass
 **/
package MainPackage;

import UtilityPackage.ConsoleClass;

import java.io.Serializable;

public class Customer implements Serializable {


    /**FIELD DECLARATIONS**/
    private String cnic;
    private double cashBalance;
    private boolean isPremium;
    private String customerId;
    private String customerPassword;
    private Double bankBalance;
    private double creditCardBalance;
    private String name;



    /**OVERLOADED CONSTRUCTORS**/
    public Customer(String name, String cnic,   double cashBalance, double creditCardBalance, double bankBalance, boolean isPremium) {
        this.name = name;
        this.cnic = cnic;

        this.cashBalance = cashBalance;
        this.isPremium = isPremium;
        this.creditCardBalance = creditCardBalance;
        this.bankBalance =bankBalance;
    }

    public Customer(String name, String cnic, double cashBalance, double creditCardBalance, boolean isPremium) {
        this.name = name;
        this.cnic = cnic;

        this.cashBalance = cashBalance;
        this.isPremium = isPremium;
        this.creditCardBalance = creditCardBalance;
    }

    /**THESE CONSTRUCTORS HAVE BEEN COMMENTATED OUT BECAUSE THEY DO NOT SERVE ANY REAL PURPOSE TO THE PROGRAM**/
/*    public MainPackage.Customer(String name, String cnic,double cashBalance, boolean isPremium) {
        this.name = name;
        this.cnic = cnic;
        this.cashBalance = cashBalance;
        this.isPremium = isPremium;
    }*/
/*    public MainPackage.Customer (String name, String cnic, double cashBalance, double creditCardBalance, double bankBalance) {

    }*/

    public Customer () {

    }



    /**SETTERS**/
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public void setBankBalance(Double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public void setCreditCardBalance(double creditCardBalance) {
        this.creditCardBalance = creditCardBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCashBalance(Double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }


/**GETTERS**/
    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public double getCreditCardBalance() {
        return creditCardBalance;
    }






    /**FOR CREATING A NEW CUSTOMER**/
    public static Customer createNew () {
      Customer customer = new Customer();
      ConsoleClass.newCustomerPrompt(customer);
        return customer;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void getDetails () {
        System.out.println("Name: " + getName());
        System.out.println("CNIC: " + getCnic());
        System.out.println("Login id: " + getCustomerId());
        System.out.println("Passowrd: " + getCustomerPassword());
        System.out.println("Cash balance: " + getCashBalance());
        System.out.println("Bank balance: " + getBankBalance());
        System.out.println("Credit card balance " +  getCreditCardBalance());
        System.out.println("Premium status: " + isPremium());

    }





}
