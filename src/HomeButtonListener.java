import javax.swing.*;                   	    // For creating GUIs and its graphical components 
import java.awt.*;              			    // For communicating to Operating System with GUIs
import java.awt.event.*;                	    // For ActionListener interface

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
 * Returns to home page when clicked
 */

public class HomeButtonListener implements ActionListener
{
    private SkiShop shop;                       // HomeButtonListener HAS-A Ski Shop to access panels
    private JPanel mainPanel;                   // HomeButtonListener HAS-A main panel
    private JPanel displayPanel;                // HomeButtonListener HAS-A main panel          

    // Assignment constructor
    public HomeButtonListener(SkiShop shop)
    {
        this.shop = shop;                       // Assign Ski Shop
        mainPanel = shop.getMainPanel();        // Assign main panel
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

        // Add label to display panel
        displayPanel.add(shop.getHomeLabel());
        // Set an empty border for spacing
        displayPanel.setBorder(BorderFactory.createEmptyBorder(70, 30, 30, 30));
        // Add panel to main panel
        mainPanel.add(displayPanel, BorderLayout.CENTER);
    }
}