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
 * Checks if Customer is interested in any of the products from the search results
 */

public class InterestedFieldListener implements ActionListener
{
	private SkiShop shop;						// InterestedFieldListener HAS-A Ski Shop
	private JTextField interestedField;			// InterestedFieldListener HAS-A text field to check input
    private JPanel interestedPanel;             // InterestedFieldListener HAS-A panel to ask for user input
	private Cart searchResults;					// InterestedFieldListener HAS-A cart for search results

	public InterestedFieldListener(SkiShop shop, JTextField interestedField, JPanel interestedPanel, Cart searchResults)
	{
		this.shop = shop;						// Assign Ski Shop
		this.interestedField = interestedField;	// Assign text field
        this.interestedPanel = interestedPanel; // Assign panel
		this.searchResults = searchResults;		// Assign search results
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Assign input
        String interested = interestedField.getText().toLowerCase();
        // If input is "yes", add the product to cart, checkout, or continue shopping
        if (interested.equals("yes") || interested.equals("y"))
        {
            // Hide current display panel
            interestedPanel.setVisible(false);
            // Create new Panel
            JPanel newPanel = new JPanel();
            // Set background color white
            newPanel.setBackground(Color.WHITE);
            // Add interested panel to display panel
            shop.getDisplayPanel().add(newPanel, BorderLayout.SOUTH);

            // Create label to display prompt to ask for desired item or if customer would like to proceed to checkout or continue shopping
            JLabel selectionLabel = new JLabel("Enter your desired selection");
            // Create text field for user input
            JTextField selectionField = new JTextField("Enter Item #");
            // Set the number of columns for text field
            selectionField.setColumns(10);
            // Set color of placeholder text
            selectionField.setForeground(Color.GRAY);
            // Add Mouse Listener to clear placeholder text when clicked
            selectionField.addMouseListener(new SelectionFieldMouseListener(selectionField));
            // Add Action Listener to check user input for their product selection
            selectionField.addActionListener(new SelectionFieldListener(shop, selectionField, searchResults));
            // Add label to panel
            newPanel.add(selectionLabel);
            // Add text field to panel
            newPanel.add(selectionField);
        }
        // If the input was no, then call method to return to main menu 
        else 
        {
            // Execute method which may throw exceptions
            try 
            {
                // Call method to start over
                shop.mainMenu();
            }
            // Catch exception and print stack trace
            catch (Exception anyExceptions)
            {
                anyExceptions.printStackTrace();
            }
        }
	}
}