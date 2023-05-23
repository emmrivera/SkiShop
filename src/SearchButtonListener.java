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
 * Searches for Products based on input entered into search bar
 */

public class SearchButtonListener implements ActionListener
{
	private JTextField searchBar;			// SearchButtonListener HAS-A search bar

	// Assignment Constructor for search bar and button
	public SearchButtonListener(JTextField searchBar)
	{
		this.searchBar = searchBar; 		// Assign search bar
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Searches for Product when user clicks magnifying glass
        searchBar.setForeground(Color.BLACK);
	}
}