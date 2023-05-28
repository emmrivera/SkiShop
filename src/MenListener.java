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

public class MenListener implements ActionListener
{
	private SkiShop shop;					// MenListener HAS-A ski shop
	private JRadioButton men;				// MenListener HAS-A radio button for gender

	public MenListener(SkiShop shop, JRadioButton men)
	{
		this.shop = shop;					// Assign ski shop
		this.men = men;						// Assign radio button gender
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// If gender button is selected set gender filter
		if (men.isSelected())
		{
			shop.setGenderFilter("Men");
		}
	}
}