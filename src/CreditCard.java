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
 * A customer of the website that has a credit card which has a number,
 * security code, and an expiration date
 */

public class CreditCard
{
    private int cardNumber;             // A customer HAS-A credit card number
    private int securityCode;           // A customer HAS-A security code for credit card
    private int expirationDate;         // A customer HAS-AN expiration date for credit card

    /**
     * Purpose: assignment constructor to create credit card
     * @param cardNumber number of credit card
     * @param securityCode 3-digit code on back of credit card
     * @param expirationDate when credit card expires
     */
    public CreditCard(int cardNumber, int securityCode, int expirationDate)
    {
        // Assign credit card number
        this.cardNumber = cardNumber;
        // Assign 3-digit security code for credit card
        this.securityCode = securityCode;
        // Assign expiration date for credit card
        this.expirationDate = expirationDate;
    }

    /**
     * Purpose: display last four digits of card number
     * @param number credit card number
     */
    public int getLastFour()
    {
        // Use try-catch block to bypass errors
        try 
        {
            // Create a String array splitting up the credit card number into individual digits
            String[] array = String.valueOf(cardNumber).split("");
            // Create a String to hold the last four digits
            String lastFour = "";
            // Use for loop to increment the last four digits to the string (starting at 4th from the last position)
            for (int i = array.length - 4; i < array.length; i++)
            {
                // Add digits to string
                lastFour += array[i];
            }
            // Return integer containing last four digits of credit card number
            return Integer.valueOf(lastFour);
        }
        catch (Exception exception)
        {   
            // Return null if exception caught
            return 0000;
        }
    }
}