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
 * Display K2 models under the "Models" menu if selected
 */

public class K2Listener implements ActionListener
{
	private SkiShop shop;					// K2Listener HAS-A Ski shop
	private JRadioButton k2;				// K2Listener HAS-A radio button for k2 products
	private JRadioButton rallybird;			// K2Listener HAS-A radio button for rallybird model
	private JRadioButton alltrack;			// K2Listener HAS-A radio button for alltrack model
	private JRadioButton tactic;			// K2Listener HAS-A radio button for tactic model
	private JRadioButton poker;				// K2Listener HAS-A radio button for poker model
	private JRadioButton reckoner;			// K2Listener HAS-A radio button for poker model
	private JRadioButton process;			// K2Listener HAS-A radio button for poker model
	private JRadioButton yeasayer;			// K2Listener HAS-A radio button for poker model
	private JRadioButton ruler;				// K2Listener HAS-A radio button for poker model
	private JRadioButton cartel;			// K2Listener HAS-A radio button for poker model
	private JRadioButton griffon;			// K2Listener HAS-A radio button for poker model

	public K2Listener(SkiShop shop, JRadioButton k2, JRadioButton rallybird, JRadioButton alltrack, JRadioButton tactic, JRadioButton poker, 
							JRadioButton reckoner, JRadioButton process, JRadioButton yeasayer, JRadioButton ruler, JRadioButton cartel, JRadioButton griffon)
	{
		this.shop = shop;					// Assign ski shop
		this.k2 = k2;						// Assign k2 radio button
		this.rallybird = rallybird;			// Assign rallybird radio button
		this.alltrack = alltrack;			// Assign alltrack radio button
		this.tactic = tactic;				// Assign tactic radio button
		this.poker = poker;					// Assign poker radio button
		this.reckoner = reckoner;			// Assign reckoner radio button
		this.process = process;				// Assign process radio button
		this.yeasayer = yeasayer;			// Assign yeasayer radio button
		this.ruler = ruler;					// Assign ruler radio button
		this.cartel = cartel;				// Assign cartel radio button
		this.griffon = griffon;				// Assign griffon radio button
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// If k2 brand radio button is selected, display models
		if (k2.isSelected())
		{
			// Display k2 models
			reckoner.setVisible(true);
			// Set brand
			shop.setBrandFilter("K2");

			// Hide other models
			rallybird.setVisible(false);
			alltrack.setVisible(false);
			tactic.setVisible(false);
			poker.setVisible(false);
			process.setVisible(false);
			yeasayer.setVisible(false);
			ruler.setVisible(false);
			cartel.setVisible(false);
			griffon.setVisible(false);
		}
	}
}