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

public class Price250Listener implements ActionListener
{
	private SkiShop shop;					// Price250Listener HAS-A ski shop
	private JRadioButton price250;			// Price250Listener HAS-A radio button for price

	public Price250Listener(SkiShop shop, JRadioButton price250)
	{
		this.shop = shop;					// Assign ski shop
		this.price250 = price250;			// Assign radio button price
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// If price button is selected set price filter
		if (price250.isSelected())
		{
			shop.setPriceFilter(250.0);
		}
	}
}