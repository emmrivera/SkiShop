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

public class CartFieldListener implements ActionListener
{
	private SkiShop shop;						// CartFieldListener HAS-A Ski Shop
    private Cart cart,                          // CartFieldListener HAS-A cart to add product to
                 searchResults;                 // CartFieldListener HAS-A cart of search results
    private JTextField cartField;               // CartFieldListener HAS-A text field for adding to cart
    private int quantity;                       // CartFieldListener HAS-A desired quantity
    private Product[][] multiSizes;             // CartFieldListener HAS-A 2D array of product sizes
    private int desiredIndex;                   // CartFieldListener HAS-A desired index for product size
    private JPanel promptPanel;                 // CartFieldListener HAS-A prompt panel

	public CartFieldListener(SkiShop shop, Cart searchResults, JTextField cartField, int quantity, Product[][] multiSizes, int desiredIndex, JPanel promptPanel)
	{
		this.shop = shop;						// Assign Ski Shop
        this.cart = shop.getCart();             // Assign cart
        this.searchResults = searchResults;     // Assign search results
        this.cartField = cartField;             // Assign text field for adding to cart
        this.quantity = quantity;               // Assign quantity
        this.multiSizes = multiSizes;           // Assign 2D product array
        this.desiredIndex = desiredIndex;       // Assign desired index
        this.promptPanel = promptPanel;         // Assign prompt panel
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
        // Assign input
        String input = cartField.getText();

        // Hide prompt panel
        promptPanel.setVisible(false);
        // Create new Panel
        JPanel newPanel = new JPanel();
        // Set background color white
        newPanel.setBackground(Color.WHITE);
        // Add to display panel
        shop.getDisplayPanel().add(newPanel, BorderLayout.SOUTH);

        // Create label to display prompt if product was added to cart or not
        JLabel addToCartLabel = new JLabel("");
        // Add label to panel
        newPanel.add(addToCartLabel);

        // If input equals "yes", continue
        if (input.equals("yes"))
        {
            // Iterate through each product in array associated with desired size (based on desired quantity)
            for (int product = 0; product < quantity; product++)
            {
                // Initialize a boolean variable for checking if the product is already in the cart to prevent duplicates
                boolean alreadyInCart = cart.contains(multiSizes[desiredIndex][product]);
                // If the item is not in the cart, continue
                if (!alreadyInCart)
                {  
                    // Execute code which might throw exceptions
                    try 
                    {
                        // Add product to cart
                        cart.addToCart(multiSizes[desiredIndex][product]);
                        // Remove product from search results
                        searchResults.removeFromCart(multiSizes[desiredIndex][product]);
                        // Remove product from inventory
                        multiSizes[desiredIndex][product].removeFromInventory(multiSizes[desiredIndex][product]);
                        // Display Product String
                        addToCartLabel.setText(multiSizes[desiredIndex][product].toString() + "added to cart!");
                    }
                    // Display stack trace and error message if exception thrown
                    catch (Exception anyExceptions)
                    {
                        // Display error message if exception thrown
                        addToCartLabel.setText("Exception thrown...");
                        // Display stack trace
                        anyExceptions.printStackTrace();
                    }
                }
                // If item was already in the cart, display prompt
                else 
                {
                    // Display that the selected item was already in the cart
                    addToCartLabel.setText("The item you've selected is already in the cart.");
                }
            }
        }
        // Otherwise, return to main menu
        else 
        {
            // Execute code which might throw exceptions
            try 
            {
                // Display prompt asking if customer would like to proceed to checkout or continue shopping
                shop.proceed(promptPanel);
            }
            // Display stack trace and error message if exception thrown
            catch (Exception anyExceptions)
            {
                // Display error message if exception thrown
                addToCartLabel.setText("Exception thrown...");
                // Display stack trace
                anyExceptions.printStackTrace();
            }
        }
    }
}