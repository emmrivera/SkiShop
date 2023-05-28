import javax.swing.*;               // For creating GUIs and its graphical components
import java.awt.*;                  // For communicating to Operating System with GUIs
import java.awt.event.*;            // For ActionListener interface

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
 * Display developer info
 */

public class AboutItemListener implements ActionListener
{
    private JFrame aboutMe;         // AboutItemListener HAS-A frame to display dev info
    private JPanel main;            // AboutItemListener HAS-A panel to add components
    private JLabel name,            // AboutItemListener HAS-A name for dev
                   email,           // AboutItemListener HAS-A name for email
                   phone;           // AboutItemListener HAS-A phone number for dev
    private JButton button;         // AboutItemListener HAS-A button for closing frame

    public void actionPerformed(ActionEvent click)
    {
        // Create frame
        aboutMe = new JFrame();
        // Create panel
        main = new JPanel();
        // Create label with dev name
        name = new JLabel("Emmanuel Rivera", 
            SwingConstants.CENTER);
        // Create label with dev email
        email = new JLabel("webdev@gmail.com",
            SwingConstants.CENTER);
        // Create label with dev phone
        phone = new JLabel("123-456-7890",
            SwingConstants.CENTER);
        // Create button to close frame
        button = new JButton("Close");
        // Add action listener for button
        button.addActionListener(
            new CloseButtonListener());
        // Set grid layout for main panel
        main.setLayout(
            new GridLayout(4, 1));

        // Add components to main panel
        main.add(name);
        main.add(email);
        main.add(phone);
        main.add(button);
        aboutMe.add(main);
        // Set title
        aboutMe.setTitle("About Me");
        // Allow frame to close on clicking "x"
        aboutMe.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);
        // Set size of frame
        aboutMe.setSize(250, 200);
        // Center frame on screen
        aboutMe.setLocationRelativeTo(null);
        // Display frame
        aboutMe.setVisible(true);
    }

    private class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent click)
        {
            // Hide frame when clicking "Close" button
            aboutMe.setVisible(false);
        }
    }
}
