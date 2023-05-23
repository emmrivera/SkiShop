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
 * Retrieves saved account info based on email provided or proceeds as guest
 */

public class LoginFieldListener implements ActionListener
{
	private SkiShop shop;						// LoginFieldListener HAS-A Ski Shop to access panels and customer
	private JPanel mainPanel;					// LoginFieldListener HAS-A main panel
	private JPanel displayPanel;				// LoginFieldListener HAS-A display panel
	private JTextField loginField;				// LoginFieldListener HAS-A login text field
	private Customer customer;					// LoginFieldListener HAS-A customer to match or create login credentials

	// Assignment constructor
	public LoginFieldListener(SkiShop shop, JTextField loginField)
	{
		this.shop = shop;						// Assign Ski Shop
		this.loginField = loginField;			// Assign login text field
		mainPanel = shop.getMainPanel();		// Assign main panel
		customer = shop.getCustomer();			// Assign customer
	}

	// Required method to override which performs action when clicked
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Get user input
		String input = loginField.getText().toLowerCase();

		// If input equals guest 
		if (input.equals("guest"))
        {
        	// Hide previous panel and display new panel
        	swapPanels();

        	// Create greetings label
        	JLabel guestLabel = new JLabel("Greetings guest!");
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
        // If entry contains a domain name, display greetings message
        else if ((input.contains("@gmail.com")) || (input.contains("@hotmail.com")) || (input.contains("@yahoo.com")))
        {
        	// Hide previous panel and display new panel
        	swapPanels();

        	// Create greetings label
            JLabel guestLabel = new JLabel("Greetings " + input + "!");
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
        // If input equals "new"
        else if (input.equals("new"))
        {
        	// Hide previous panel and display new panel
        	swapPanels();

        	// Create greetings label
        	JLabel guestLabel = new JLabel("Enter your email:");
        	// Create text field for user's email
	        JTextField newLoginField = new JTextField();
	        // Set the number of columns (desired width)
	        newLoginField.setColumns(10);
	        // Add Action Listener to text field to retrieve user info based on email given or proceed as a
	        newLoginField.addActionListener(new NewLoginListener(shop, guestLabel, newLoginField));
        	// Add label to display panel
        	displayPanel.add(guestLabel);
        	// Add text field to display panel
        	displayPanel.add(newLoginField);
        	// Add display panel to main panel
        	mainPanel.add(displayPanel, BorderLayout.CENTER);
        }
	}

	// Method to hide previous panel and display new panel
	public void swapPanels()
	{
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
	}
}