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
 * Responsibilities of interface:
 * Allows a product to be tried on (worn)
 */

public interface Wearable
{
    /**
     * Purpose: wear the product
     */
    void tryOn(Customer customer);
}