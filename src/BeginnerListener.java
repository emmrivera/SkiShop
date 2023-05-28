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
 * Set skill filter if radio button selected
 */

public class BeginnerListener implements ActionListener
{
	private SkiShop shop;					// BeginnerListener HAS-A ski shop
	private JRadioButton beginner;			// BeginnerListener HAS-A radio button for skill

	public BeginnerListener(SkiShop shop, JRadioButton beginner)
	{
		this.shop = shop;					// Assign ski shop
		this.beginner = beginner;			// Assign radio button skill
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// If skill button is selected set skill filter
		if (beginner.isSelected())
		{
			shop.setSkillFilter("Beginner");
		}
	}
}