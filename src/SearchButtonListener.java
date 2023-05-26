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
 * Searches for Products based on input entered into search bar
 */

public class SearchButtonListener implements ActionListener
{
	private SkiShop shop;					// SearchButtonListener HAS-A Ski Shop
	private JTextField searchBar;			// SearchButtonListener HAS-A search bar

	// Assignment Constructor for search bar and button
	public SearchButtonListener(SkiShop shop, JTextField searchBar)
	{
		this.shop = shop;					// Assign ski shop
		this.searchBar = searchBar; 		// Assign search bar
	}

	// Searches for Product when user clicks magnifying glass
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Store input
		String input = searchBar.getText().toLowerCase();

		// Try-block to run method which may throw an exception
		try
		{
			// Call broadSearch method to search for Skis
			shop.broadSearch(input);
		}
		// Catch-block to catch any exceptions and print stack trace
		catch (Exception anyExceptions)
		{
			anyExceptions.printStackTrace();
		}
	}
}