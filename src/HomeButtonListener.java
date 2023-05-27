import javax.swing.*;                   	    // For creating GUIs and its graphical components 
import java.awt.*;              			    // For communicating to Operating System with GUIs
import java.awt.event.*;                	    // For ActionListener interface

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
 * Returns to home page when clicked
 */

public class HomeButtonListener implements ActionListener
{
    private SkiShop shop;                       // HomeButtonListener HAS-A Ski Shop to access panels  

    // Assignment constructor
    public HomeButtonListener(SkiShop shop)
    {
        this.shop = shop;                       // Assign Ski Shop
    }

    // Required method to override which performs action when clicked
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // Execute method call which might throw exceptions
        try 
        {
            // Call method to go to "home" screen
            shop.mainMenu();
        }
        // Display stack trace if any exceptions are caught
        catch (Exception anyExceptions)
        {
            anyExceptions.printStackTrace();
        }
    }
}