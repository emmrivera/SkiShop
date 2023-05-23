import javax.swing.*;                   // For creating GUIs and its graphical components 
import java.awt.event.*;                // For ActionListener interface

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
 * Restart program when "Restart" menu item clicked
 */

public class RestartItemListener implements ActionListener
{
    private SkiShop shop;               // RestartItemListener HAS-A Ski Shop to close

    public RestartItemListener(SkiShop shop)
    {
        this.shop = shop;               // Assign Ski Shop
    }
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Close first Ski Shop program when clicked
		shop.setVisible(false);

        // Try-catch block to start program that might throw exceptions
         try 
         {  
            // Create instance of program
            new SkiShop("Skitopia").enter();
         }
         // Catch and handle any exceptions thrown during program execution
         catch (Exception anyExceptions)
         {
            // Display stack trace
            anyExceptions.printStackTrace();
         }
	}
}