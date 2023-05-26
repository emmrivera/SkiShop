import javax.swing.*;                               // For creating GUIs and its graphical components 
import java.awt.*;                                  // For communicating to Operating System with GUIs
import java.awt.event.*;                            // For ActionListener interface

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
 * Checks user input for product selection
 */

public class SelectionFieldListener implements ActionListener
{               
    private SkiShop shop;                           // SelectionFieldListener HAS-A Ski Shop
    private JTextField selectionField;              // SelectionFieldListener HAS-A text field             
    private Cart searchResults;                     // SelectionFieldListener HAS-A cart for search results                         

    // Assignment constructor
    public SelectionFieldListener(SkiShop shop, JTextField selectionField, Cart searchResults)
    {
        this.shop = shop;                           // Assign ski shop
        this.selectionField = selectionField;       // Assign text field
        this.searchResults = searchResults;         // Assign search results
    }

    // Required method to override which performs action when clicked
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Get input
        String input = selectionField.getText();

        // Check if input is correct/valid
        try 
        {
            // Assign/convert input to an int
            int itemNumber = Integer.valueOf(input);
            // If no exception thrown, call interested() method to continue
            shop.interested(searchResults, itemNumber);
        }
        // Catch any exception and print stack trace
        catch (Exception anyExceptions)
        {
            // Display prompt to ask customer to re-enter correct input
            selectionField.setText("Invalid entry type, please enter an integer.");
            // Change color of placeholder text
            selectionField.setForeground(Color.GRAY);
            // Display stack trace
            anyExceptions.printStackTrace();
        }
    }
}