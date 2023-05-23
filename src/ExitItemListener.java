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
 * Exit program when "Exit" menu item clicked
 */

public class ExitItemListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Exit program when clicked
		System.exit(0);
	}
}