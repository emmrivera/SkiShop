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

public class SizeFieldListener implements ActionListener
{
	private SkiShop shop;						// SizeFieldListener HAS-A Ski Shop
    private JTextField sizeField;               // SizeFieldListener HAS-A text field for desired size
    private JPanel promptPanel;                 // SizeFieldListener HAS-A panel for prompting Customer
    private Cart searchResults;                 // SizeFieldListener HAS-A cart for search results

	public SizeFieldListener(SkiShop shop, JTextField sizeField, JPanel promptPanel, Cart searchResults)
	{
		this.shop = shop;						// Assign Ski Shop
        this.sizeField = sizeField;             // Assign text field of size
        this.promptPanel = promptPanel;         // Assign prompt panel
        this.searchResults = searchResults;     // Assign search results
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
        // Store input
        String input = sizeField.getText();

        // Get array of available product sizes
        int[] productSizes = searchResults.getProductSizes();
        // Initialize a boolean variable for checking if the size of product is available
        boolean sizeAvailable = false;
        // Initialize desired index of product
        int desiredIndex = -1;

        // Execute conversion which may thrown exceptions
        try
        {
            // Convert string to int
            int desiredSize = Integer.valueOf(input);
            // Iterate through each available size
            for (int size = 0; size < productSizes.length; size++)
            {   
                // If size is available, assign true
                if (desiredSize == productSizes[size])
                {
                    // Store index associated with desired size for next step
                    desiredIndex = size;
                    // Assign true
                    sizeAvailable = true;
                }
            }
            // If size is not available, display message
            if (!sizeAvailable)
            {
                // Display error message with placeholder text
                sizeField.setText("Size not available, please try again.");
                // Change placeholder text color to gray
                sizeField.setForeground(Color.GRAY);
            }
            // Otherwise if size is available, 
            else
            {
                // Call method to prompt Customer for desired quantity
                shop.getDesiredQuantity(searchResults, desiredIndex, promptPanel);
            }
        }
        // Catch any exception and print stack trace
        catch (Exception anyExceptions)
        {
            // Display error message with placeholder text
            sizeField.setText("Invalid entry, please enter an integer.");
            // Change placeholder text color to gray
            sizeField.setForeground(Color.GRAY);
            // Display stack trace
            anyExceptions.printStackTrace();
        }
    }
}