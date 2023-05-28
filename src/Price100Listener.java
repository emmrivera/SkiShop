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
 * Set price filter if radio button selected
 */

public class Price100Listener implements ActionListener
{
	private SkiShop shop;					// Price100Listener HAS-A ski shop
	private JRadioButton price100;			// Price100Listener HAS-A radio button for price

	public Price100Listener(SkiShop shop, JRadioButton price100)
	{
		this.shop = shop;					// Assign ski shop
		this.price100 = price100;			// Assign radio button price
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// If price button is selected set price filter
		if (price100.isSelected())
		{
			shop.setPriceFilter("100");
		}
	}
}