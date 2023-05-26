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

public class TitleListener implements MouseListener
{
    private SkiShop shop;                       // TitleListener HAS-A Ski Shop to access panels
    private JPanel mainPanel;                   // TitleListener HAS-A main panel
    private JPanel displayPanel;                // TitleListener HAS-A main panel          

    // Assignment constructor
    public TitleListener(SkiShop shop)
    {
        this.shop = shop;                       // Assign Ski Shop
        mainPanel = shop.getMainPanel();        // Assign main panel
    }

    // Required method to override which performs action when clicked
    @Override
    public void mouseClicked(MouseEvent e) 
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
        // Add panel to main panel
        mainPanel.add(displayPanel, BorderLayout.CENTER);
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        // Handle mouse pressed event
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        // Handle mouse released event
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        // Handle mouse entered event
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        // Handle mouse exited event
    }
}