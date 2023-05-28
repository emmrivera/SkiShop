import javax.swing.*;                   	// For creating GUIs and its graphical components 
import java.awt.event.*;                	// For ActionListener interface

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
 * Displays filters for an advanced search
 */

public class FilterButtonListener implements ActionListener
{
	private JButton filterButton;			// FilterButtonListener HAS-A filter button
	private JPopupMenu filterMenu;			// FilterButtonListener HAS-A filter popup menu

	public FilterButtonListener(JButton filterButton, JPopupMenu filterMenu)
	{
		this.filterButton = filterButton;	// Assign filter button
		this.filterMenu = filterMenu;		// Assign filter menu
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Display popup filter menu
	    filterMenu.show(filterButton, 0, filterButton.getHeight());
	}
}