/**
 * Lead Author(s):
 * @author Emmanuel Rivera
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *  
 * Version/date: 1.0
 * 
 * Responsibilities of class:
 * A customer of the website that has a username, first and last name, email address,
 * and a billing and shipping address - most of which can be changed/updated
 */

public class Customer
{
    private String userName;            // A customer HAS-A username
    private String firstName;           // A customer HAS-A first name
    private String lastName;            // A customer HAS-A last name
    private String emailAddress;        // A customer HAS-AN email address
    private Address billingAddress;     // A customer HAS-A billing Address
    private Address shippingAddress;    // A customer HAS-A shipping Address
    private int shoeSize;               // A customer HAS-A shoe size
    // private CreditCard creditCard;      // A customer HAS-A credit card

    /**
     * Purpose: empty constructor
     */
    public Customer()
    {
    }

    /**
     * Purpose: constructor to initialize the first and last name of the customer
     * @param firstName first name of customer
     * @param lastName last name of customer
     */
    public Customer(String firstName, String lastName)
    {
        // Assign first name
        this.firstName = firstName;
        // Assign last name
        this.lastName = lastName;
    }

    /**
     * Purpose: set username of customer
     * @param userName customer's login
     */
    public void setUserName(String userName)
    {
        // Assign username
        this.userName = userName;
    }

    /**
     * Purpose: get username of customer
     * @param userName customer's login
     */
    public String getUserName()
    {
        // Assign username
        return userName;
    }

    /**
     * Purpose: set first name of customer
     * @param firstName 
     */
    public void setFirstName(String firstName)
    {   
        // Assign first name
        this.firstName = firstName;
    }

    /**
     * Purpose: get first name of customer
     * @param firstName customer's login
     */
    public String getFirstName()
    {
        // Assign first name
        return firstName;
    }

    /**
     * Purpose: set last name of customer
     * @param lastName
     */
    public void setLastName(String lastName)
    {
        // Assign last name
        this.lastName = lastName;
    }

    /**
     * Purpose: get last name of customer
     * @param lastName customer's login
     */
    public String getLastName()
    {
        // Assign last name
        return lastName;
    }

    /**
     * Purpose: set email address of customer
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress)
    {
        // Assign email address
        this.emailAddress = emailAddress;
    }

    /**
     * Purpose: get email address of customer
     * @param emailAddress customer's login
     */
    public String getEmailAddress()
    {
        // Assign email address
        return emailAddress;
    }

    /**
     * Purpose: set shoe size of customer
     * @param shoeSize
     */
    public void setShoeSize(int shoeSize)
    {
        // Assign shoe size
        this.shoeSize = shoeSize;
    }

    /**
     * Purpose: get shoe size of customer
     * @param shoeSize customer's login
     */
    public int getShoeSize()
    {
        // Assign shoe size
        return shoeSize;
    }

    /**
     * Purpose: set billing address for customer
     */
    public void setBillingAddress(int streetNumber, String streetName, String city, String state, int zipCode)
    {
        // Create an instance of an Address object passing the fields into the constructor
        Address customerAddress = new Address(streetNumber, streetName, city, state, zipCode);
        // Assign address to billing address
        this.billingAddress = customerAddress;
    }

    /**
     * Purpose: get billing address for customer
     */
    public Address getBillingAddress()
    {
        return billingAddress;
    }


    /**
     * Purpose: set shipping address for customer (if shipping is same as billing)
     * Shallow/Reference copy
     */
    public void setShippingAddress(Address billingAddress)
    {
        // Assign billing address to shipping address
        this.shippingAddress = billingAddress;
    }


    /**
     * Purpose: set shipping address for customer
     */
    public void setShippingAddress(int streetNumber, String streetName, String city, String state, int zipCode)
    {
        // Create an instance of an Address object passing the fields into the constructor
        Address customerAddress = new Address(streetNumber, streetName, city, state, zipCode);
        // Assign address to shipping address
        this.shippingAddress = customerAddress;
    }

    // /**
    //  * Purpose: add credit card for customer
    //  */
    // public void addCreditCard(int cardNumber, int securityCode, int expirationDate)
    // {
    //     // Create a credit card passing the info as arguments
    //     creditCard = new CreditCard(cardNumber, securityCode, expirationDate);
    // }

    /**
     * Purpose: display customer info
     * @return customer 
     */
    @Override
    public String toString()
    {
        // Create string and display the customer's name
        String customer = "Customer: " + firstName + " " + lastName + "\n";
        // Add email address
        customer += "Email: " + emailAddress + "\n";
        // // Add the last four digits of credit card number
        // customer += "Credit Card: ending in " + creditCard.getLastFour() + "\n";
        // Add the billing address
        customer += "Billing Address: " + billingAddress.toString() + "\n";
        // Add the shipping address
        if (shippingAddress == billingAddress)
        {
            customer += "Shipping Address: same as billing address\n";
        }
        else 
        {
            customer += "Shipping Address: " + shippingAddress.toString() + "\n";
        }
        // Return the customer info
        return customer;
    }
}