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

public class AllPricesListener implements ActionListener
{
	private SkiShop shop;					// AllPricesListener HAS-A ski shop
	private JRadioButton allPrices;			// AllPricesListener HAS-A radio button for price

	public AllPricesListener(SkiShop shop, JRadioButton allPrices)
	{
		this.shop = shop;					// Assign ski shop
		this.allPrices = allPrices;			// Assign radio button price
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// If price button is selected set price filter
		if (allPrices.isSelected())
		{
			shop.setPriceFilter("0");
		}
	}
}