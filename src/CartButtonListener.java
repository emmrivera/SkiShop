import javax.swing.*;                   		// For creating GUIs and its graphical components 
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
 * Displays products in cart
 */

public class CartButtonListener implements ActionListener
{
	private SkiShop shop;						// CartButtonListener HAS-A Ski Shop to access panels and cart
	private JPanel mainPanel;					// CartButtonListener HAS-A main panel
	private JPanel displayPanel;				// CartButtonListener HAS-A display panel
	private Cart cart;							// CartButtonListener HAS-A cart	

	public CartButtonListener(SkiShop shop)
	{
		this.shop = shop;						// Assign Ski Shop
		mainPanel = shop.getMainPanel();		// Assign main panel
		cart = shop.getCart();					// Assign cart
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Hide current display panel
        shop.getDisplayPanel().setVisible(false);
        // Create new Panel
        JPanel newPanel = new JPanel(new BorderLayout());
        // Set background color white
        newPanel.setBackground(Color.WHITE);
        // Set new display panel
        shop.setDisplayPanel(newPanel);
        // Assign display panel
        displayPanel = shop.getDisplayPanel();

		// Check if cart has any products
		if (cart.getQuantity() > 0)
		{
			// Create label to display message
	        JLabel messageLabel = new JLabel("Here are the product(s) in your cart");
	        // Center label
            messageLabel.setVerticalAlignment(JLabel.CENTER);
            messageLabel.setHorizontalAlignment(JLabel.CENTER);
	        // Add label to display panel
	        displayPanel.add(messageLabel, BorderLayout.NORTH);
	        // Set an empty border for spacing
        	displayPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        	// Create text area to display products in cart
            JTextArea cartTextArea = new JTextArea(cart.toString("cart"));
            // Restrict editing
            cartTextArea.setEditable(false);
            // Wrap sentences to next line
            cartTextArea.setLineWrap(true);
            // Wrap entire words to next line
            cartTextArea.setWrapStyleWord(true);

            // Create scroll bar for the text area (search results)
            JScrollPane scrollBar = new JScrollPane(cartTextArea);
            // Set an empty border for spacing
            scrollBar.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            // Add text area to display panel
            displayPanel.add(scrollBar, BorderLayout.CENTER);

	        // Add panel to main panel
	        mainPanel.add(displayPanel, BorderLayout.CENTER);
		}
		else 
		{
			// Create label to display message
	        JLabel messageLabel = new JLabel("You have 0 products in your cart.");
	        // Center label
	        messageLabel.setVerticalAlignment(JLabel.CENTER); 
	        messageLabel.setHorizontalAlignment(JLabel.CENTER); 
	        // Add button to display panel
	        displayPanel.add(messageLabel, BorderLayout.NORTH);
	        // Set an empty border for spacing
        	displayPanel.setBorder(BorderFactory.createEmptyBorder(70, 30, 30, 30));
	        // Add panel to main panel
	        mainPanel.add(displayPanel, BorderLayout.CENTER);
		}
	}
}