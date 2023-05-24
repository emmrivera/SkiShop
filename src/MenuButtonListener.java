import javax.swing.*;                   // For creating GUIs and its graphical components 
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
 * Displays popup menu of Product categories to select
 */

public class MenuButtonListener implements ActionListener
{
	private JPopupMenu productMenu;		// MenuButtonListener HAS-A pop up product menu
	private JButton menuButton;			// MenuButtonListener HAS-A menu button

	public MenuButtonListener(JPopupMenu productMenu, JButton menuButton)
	{
		this.productMenu = productMenu;	// Assign product menu
		this.menuButton = menuButton;	// Assign menu button
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Display popup product menu, positioned underneath menu button
	    productMenu.show(menuButton, 0, menuButton.getHeight());
	}
}