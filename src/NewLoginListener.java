import javax.swing.*;                   	// For creating GUIs and its graphical components 
import java.awt.*;              			// For communicating to Operating System with GUIs
import java.awt.event.*;                	// For ActionListener interface

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
 * Creates new login
 */

public class NewLoginListener implements ActionListener
{
	private SkiShop shop;						// NewLoginListener HAS-A Ski Shop to access panels and customer
	private JPanel mainPanel;					// NewLoginListener HAS-A main panel
	private JPanel displayPanel;				// NewLoginListener HAS-A display panel
	private JLabel guestLabel;					// NewLoginListener HAS-A guest label
	private JTextField newLoginField;			// NewLoginListener HAS-A new login text field
	private Customer customer;					// NewLoginListener HAS-A customer to match or create login credentials
	private int clicks = 0;						// NewLoginListener HAS-A counter for clicks

	// Assignment constructor
	public NewLoginListener(SkiShop shop, JLabel guestLabel, JTextField newLoginField)
	{
		this.shop = shop;						// Assign Ski Shop
		this.guestLabel = guestLabel;			// Assign guest label
		this.newLoginField = newLoginField;		// Assign new login text field
		mainPanel = shop.getMainPanel();		// Assign main panel
		customer = shop.getCustomer();			// Assign customer
	}

	// Required method to override which performs action when clicked
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Get user input
        String input = newLoginField.getText().toLowerCase();

        // Continue to ask for email if no domain name was entered
        while (clicks == 0)
        {
            // If input contains an email domain name, increment variable to exit loop
            if ((input.contains("@gmail.com")) || (input.contains("@hotmail.com")) || (input.contains("@yahoo.com")))
            {
            	// Set customer's email address
                customer.setEmailAddress(input);
                // Set text field's text
        		newLoginField.setText("");
        		// Increment clicks
        		clicks++;
            }
        }

		if (clicks == 1)
		{
			// Ask for first name
        	guestLabel.setText("Enter your first name:");
        	// Set customer's first name
        	customer.setFirstName(input);
        	// Set text field's text
        	newLoginField.setText("");
		}
		else if (clicks == 2)
		{
			// Ask for last name
        	guestLabel.setText("Enter your last name:");
			// Set customer's last name
        	customer.setLastName(input);
        	// Set text field's text
        	newLoginField.setText("");
		}
		else if (clicks == 3)
		{
			// Ask for shoe size
        	guestLabel.setText("Enter your shoe size:");
        	// Set text field's text
        	newLoginField.setText("");

        	// Hide current display panel
	        shop.getDisplayPanel().setVisible(false);
	        // Create new Panel
	        JPanel newPanel = new JPanel();
	        // Set background color white
	        newPanel.setBackground(Color.WHITE);
	        // Set new display panel
	        shop.setDisplayPanel(newPanel);
	        // Assign display panel
	        displayPanel = shop.getDisplayPanel();

	    	// Display greetings
        	guestLabel.setText("Greetings " + customer.getFirstName() + "!");
	    	// Create back to home button
        	JButton homeButton = new JButton("Back to Home");
        	// Add Action Listener to return to home page
        	homeButton.addActionListener(new HomeButtonListener(shop));
            // Add label to display panel
        	displayPanel.add(guestLabel);
        	// Add button to display panel
        	displayPanel.add(homeButton);
        	// Add display panel to main panel
        	mainPanel.add(displayPanel, BorderLayout.CENTER);
		}

		// Increment clicks
        clicks++;
	}
}