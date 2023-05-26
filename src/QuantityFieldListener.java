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

public class QuantityFieldListener implements ActionListener
{
	private SkiShop shop;						// QuantityFieldListener HAS-A Ski Shop
    private JTextField quantityField;           // QuantityFieldListener HAS-A text field for desired quantity
    private JPanel promptPanel;                 // QuantityFieldListener HAS-A prompt panel
    private Cart searchResults;                 // QuantityFieldListener HAS-A cart for search results
    private int desiredIndex;                   // QuantityFieldListener HAS-A desired index of product in size array

	public QuantityFieldListener(SkiShop shop, JTextField quantityField, JPanel promptPanel, Cart searchResults, int desiredIndex)
	{
		this.shop = shop;						// Assign Ski Shop
        this.quantityField = quantityField;     // Assign text field     
        this.promptPanel = promptPanel;         // Assign prompt panel
        this.searchResults = searchResults;     // Assign search results cart
        this.desiredIndex = desiredIndex;       // Assign desired index
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
        // Initialize a boolean variable for checking if the quantity of product is available
        boolean quantityAvailable = false;
        // Get 2D array of Products (based on size)
        Product[][] multiSizes = searchResults.getMultiSizes();
        // Try-Block to handle exceptions thrown from invalid input
        try 
        {
            // Store input
            String input = quantityField.getText();
            // Convert String to an int
            int quantity = Integer.valueOf(input);
            // If quantity of desired size is available (by checking associated product array length), assign true
            if (quantity > 0 && quantity <= multiSizes[desiredIndex].length)
            {   
                // Assign true
                quantityAvailable = true;
            }
            // If desired quantity is not available, display error message
            if (!quantityAvailable)
            {
                // Display error message in placeholder text
                quantityField.setText("Invalid quantity, please try again.");
            }
            // Otherwise if quantity available, call addToCart() method to add to cart
            else 
            {
                shop.addToCart(searchResults, multiSizes, quantity, desiredIndex, promptPanel);
            }
        }
        // Catch any exceptions from invalid input and display prompt
        catch (Exception anyExceptions)
        {
            // Display prompt to ask customer to re-enter correct input
            System.out.println("Invalid entry, please enter an integer.");
            // Display stack trace
            anyExceptions.printStackTrace();
        }
    }
}