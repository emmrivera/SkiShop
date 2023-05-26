import javax.swing.*;                       // For creating GUIs and its graphical components 
import java.awt.*;                          // For communicating to Operating System with GUIs
import java.awt.event.*;                    // For ActionListener interface

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
 * Displays prompts to sign in when menu item clicked
 */

public class LoginButtonListener implements ActionListener
{
    private SkiShop shop;                   // LoginButtonListener HAS-A Ski Shop to access panels and customer
    private JButton loginButton;            // LoginButtonListener HAS-A login button
    private JPanel mainPanel;               // LoginButtonListener HAS-A main panel for display panel
    private JPanel displayPanel;            // LoginButtonListener HAS-A panel to display components
    private Customer customer;              // LoginButtonListener HAS-A customer to match or create login credentials

    // Assignment constructor
    public LoginButtonListener(SkiShop shop, JButton loginButton)
    {
    	this.shop = shop;                  // Assign Ski Shop
        this.loginButton = loginButton;    // Assign login button
    	mainPanel = shop.getMainPanel();   // Assign main panel
    	customer = shop.getCustomer();     // Assign customer
    }

    // Required method to override which performs action when clicked
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

        // Create login label
        JLabel loginLabel = new JLabel("\nEnter email to login");
        // Center horizontally
        loginLabel.setHorizontalAlignment(JLabel.CENTER); 
        // Center vertically
        loginLabel.setVerticalAlignment(JLabel.CENTER); 
        // Add login label to panel
        displayPanel.add(loginLabel);

        // Create text field for user's email
        JTextField loginField = new JTextField("\"new\" to create a new user or \"guest\"");
        // Set the number of columns (desired width)
        loginField.setColumns(20);
        // Set placeholder text color gray
        loginField.setForeground(Color.GRAY);
        // Add Mouse Listener to clear placeholder text when clicked
        loginField.addMouseListener(new LoginFieldMouseListener(loginField));
        // Add Action Listener to text field to retrieve user info based on email given or proceed as a
        loginField.addActionListener(new LoginFieldListener(shop, loginField, loginButton));
        
        // Add text field to panel
        displayPanel.add(loginField);
        // Add display panel to main panel
        mainPanel.add(displayPanel, BorderLayout.CENTER);
    }
}