import javax.swing.*;                   // For creating GUIs and its graphical components 
import java.awt.*;                      // For communicating to Operating System with GUIs
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
 * To search for bindings when menu item clicked
 */

public class BindingsItemListener implements ActionListener
{
	private SkiShop shop;				// BindingsItemListener HAS-A Ski Shop

	// Assignment Constructor for search bar and button
	public BindingsItemListener(SkiShop	shop)
	{
		this.shop = shop;				// Assign ski shop
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Try-block to run method which may throw an exception
		try
		{
			// Call typeSearch method to search for bindings
			shop.typeSearch("Bindings");
		}
		// Catch-block to catch any exceptions and print stack trace
		catch (Exception anyExceptions)
		{
			anyExceptions.printStackTrace();
		}
	}
}