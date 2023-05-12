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
 * An address where a customer resides which has a street number, name, city, state, and zipcode
 */

public class Address
{
    private int streetNumber;           // A customer HAS-A street number for their address
    private int zipCode;                // A customer HAS-A zip code for their address
    private String streetName;          // A customer HAS-A street name for their address
    private String city;                // A customer HAS-A city for their address
    private String state;               // A customer HAS-A state for their address

    /**
     * Purpose: constructor which initializes a billing address of customer
     * @param streetNumber
     * @param streetName
     * @param city
     * @param state
     * @param zipcode
     */
    public Address(int streetNumber, String streetName, String city, String state, int zipCode)
    {
        // Assign street number
        this.streetNumber = streetNumber;
        // Assign street name
        this.streetName = streetName;
        // Assign city
        this.city = city;
        // Assign state
        this.state = state;
        // Assign zipcode
        this.zipCode = zipCode;
    }

    /**
     * Purpose: display customer's address
     * @return address
     */
    public String toString()
    {
        // Create string and display the customer's street number and name
        String address = streetNumber + " " + streetName + " " + city + " " + state + " " + zipCode;
        // Return the address
        return address;
    }
}