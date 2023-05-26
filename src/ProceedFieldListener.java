import javax.swing.*;                           // For creating GUIs and its graphical components 
import java.awt.*;              				// For communicating to Operating System with GUIs
import java.awt.event.*;                		// For ActionListener interface

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
 * Checks if desired size from user input is valid
 */

public class ProceedFieldListener implements ActionListener
{
	private SkiShop shop;				      // ProceedFieldListener HAS-A Ski Shop
    private JTextField proceedField;          // ProceedFieldListener HAS-A text field for desired proceed

	public ProceedFieldListener(SkiShop shop, JTextField proceedField)
	{
		this.shop = shop;				      // Assign Ski Shop
        this.proceedField = proceedField;     // Assign text field     
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{  
        // Assign input to a String
        String input = proceedField.getText();

        // Execute code which may throw exceptions
        try 
        {
            // If input is "checkout", exit loop and proceed to checkout
            if (input.equals("checkout"))
            {
                shop.checkout();
            }
            // Otherwise, exit loop and return to main menu
            else 
            {
                shop.mainMenu();
            }
        }
        // Display stack trace if any exceptions thrown
        catch (Exception anyExceptions)
        {
            anyExceptions.printStackTrace();
        }
        
    }
}