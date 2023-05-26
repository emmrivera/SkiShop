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
        JPanel newPanel = new JPanel();
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
	        JLabel messageLabel = new JLabel("Here are the product(s) in your cart: [Quantity: " 
	        							+ cart.getQuantity() + "]");
	        // Add label to display panel
	        displayPanel.add(messageLabel, BorderLayout.NORTH);
	        // Create label to display products
	        JLabel products = new JLabel(cart.toString());
	        // Add button to display panel
	        displayPanel.add(products, BorderLayout.SOUTH);
	        // Add panel to main panel
	        mainPanel.add(displayPanel, BorderLayout.CENTER);
		}
		else 
		{
			// Create label to display message
	        JLabel messageLabel = new JLabel("You have 0 products in your cart.");
	        // Center horizontally
	        messageLabel.setHorizontalAlignment(JLabel.CENTER); 
	        // Center vertically
	        messageLabel.setVerticalAlignment(JLabel.CENTER); 
	        // Add button to display panel
	        displayPanel.add(messageLabel, BorderLayout.NORTH);
	        // Add panel to main panel
	        mainPanel.add(displayPanel, BorderLayout.CENTER);
		}
	}
}