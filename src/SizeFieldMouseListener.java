import javax.swing.*;                   // For creating GUIs and its graphical components 
import java.awt.*;                      // For communicating to Operating System with GUIs
import java.awt.event.*;                // For ActionListener interface

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
 * Clears text field when clicked
 */

public class SizeFieldMouseListener implements MouseListener
{
    private JTextField sizeField;       // SizeFieldMouseListener HAS-A text field to clear
    private int clicks = 0;             // SizeFieldMouseListener HAS-A number of clicks

    // Assignment Constructor for search bar and button
    public SizeFieldMouseListener(JTextField sizeField)
    {
        this.sizeField = sizeField;     // Assign text field
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        // Perform once
        if (clicks == 0)
        {
            // Clears placeholder text when clicked
            sizeField.setText("");
            // Set text color black when clicked
            sizeField.setForeground(Color.BLACK);
        }

        // Increment clicks
        clicks++;
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