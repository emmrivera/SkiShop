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
 * Set gender filter if radio button selected
 */

public class WomenListener implements ActionListener
{
	private SkiShop shop;					// WomenListener HAS-A ski shop
	private JRadioButton women;				// WowomenListener HAS-A radio button for gender

	public WomenListener(SkiShop shop, JRadioButton women)
	{
		this.shop = shop;					// Assign ski shop
		this.women = women;					// Assign radio button gender
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// If gender button is selected set gender filter
		if (women.isSelected())
		{
			shop.setGenderFilter("Women");
		}
	}
}