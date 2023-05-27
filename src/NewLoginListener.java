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
	private JButton loginButton;				// NewLoginListener HAS-A login button
	private JPanel mainPanel;					// NewLoginListener HAS-A main panel
	private JPanel displayPanel;				// NewLoginListener HAS-A display panel
	private JLabel guestLabel;					// NewLoginListener HAS-A guest label
	private JTextField newLoginField;			// NewLoginListener HAS-A new login text field
	private Customer customer;					// NewLoginListener HAS-A customer to match or create login credentials
	private int clicks = 0;						// NewLoginListener HAS-A counter for clicks

	// Assignment constructor
	public NewLoginListener(SkiShop shop, JLabel guestLabel, JTextField newLoginField, JButton loginButton)
	{
		this.shop = shop;						// Assign Ski Shop
		this.loginButton = loginButton;			// Assign login button
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
        String input = newLoginField.getText();

        // If a valid email is detected (with a domain), continue to next case
        switch (clicks)
        {
        	case 0:
        		// If input contains an email domain name, increment variable to exit loop
	            if ((input.contains("@gmail.com")) || (input.contains("@hotmail.com")) || (input.contains("@yahoo.com")))
	            {
	            	// Set customer's email address
	                customer.setEmailAddress(input);
	                // Set text field's text
	        		newLoginField.setText("");
	        		// Ask for first name
	        		guestLabel.setText("Enter your first name:");
	        		// Increment clicks
	        		clicks++;
	            }
	            // Break out of switch statement
	            break;
	    	case 1:
	        	// Set customer's first name
	        	customer.setFirstName(input);
	        	// Set text field's text
	        	newLoginField.setText("");
	        	// Ask for last name
	        	guestLabel.setText("Enter your last name:");
	        	// Increment clicks
	        	clicks++;
	        	// Break out of switch statement
	            break;
	        case 2:
				// Set customer's last name
	        	customer.setLastName(input);
	        	// Set text field's text
	        	newLoginField.setText("");
	        	// Ask for shoe size
	        	guestLabel.setText("Enter your shoe size:");
	        	// Increment clicks
	        	clicks++;
	        	// Break out of switch statement
	            break;
	        case 3:
	        	// Set customer's shoe size
	        	customer.setShoeSize(Integer.valueOf(input));
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
	            // Add label to display panel
	        	displayPanel.add(guestLabel);
	        	// Add button to display panel
	        	displayPanel.add(shop.getHomeButton());
	        	// Set an empty border for spacing
        		displayPanel.setBorder(BorderFactory.createEmptyBorder(70, 30, 30, 30));
	        	// Add display panel to main panel
	        	mainPanel.add(displayPanel, BorderLayout.CENTER);
	        	// Change login button text to Customer's name
	        	loginButton.setText(customer.getFirstName());
	        	// Break out of switch statement
	            break;
    	}
	}
}