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
 * Set model filter if radio button selected
 */

public class RallybirdListener implements ActionListener
{
	private SkiShop shop;					// RallybirdListener HAS-A ski shop
	private JRadioButton rallybird;			// RallybirdListener HAS-A radio button for model

	public RallybirdListener(SkiShop shop, JRadioButton rallybird)
	{
		this.shop = shop;					// Assign ski shop
		this.rallybird = rallybird;			// Assign radio button model
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// If model button is selected set model filter
		if (rallybird.isSelected())
		{
			shop.setModelFilter("Rallybird");
		}
	}
}