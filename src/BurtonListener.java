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
 * Display Burton models under the "Models" menu if selected
 */

public class BurtonListener implements ActionListener
{
	private SkiShop shop;					// BurtonListener HAS-A Ski shop
	private JRadioButton burton;			// BurtonListener HAS-A radio button for burton products
	private JRadioButton rallybird;			// BurtonListener HAS-A radio button for rallybird model
	private JRadioButton alltrack;			// BurtonListener HAS-A radio button for alltrack model
	private JRadioButton tactic;			// BurtonListener HAS-A radio button for tactic model
	private JRadioButton poker;				// BurtonListener HAS-A radio button for poker model
	private JRadioButton reckoner;			// BurtonListener HAS-A radio button for poker model
	private JRadioButton process;			// BurtonListener HAS-A radio button for poker model
	private JRadioButton yeasayer;			// BurtonListener HAS-A radio button for poker model
	private JRadioButton ruler;				// BurtonListener HAS-A radio button for poker model
	private JRadioButton cartel;			// BurtonListener HAS-A radio button for poker model
	private JRadioButton griffon;			// BurtonListener HAS-A radio button for poker model

	public BurtonListener(SkiShop shop, JRadioButton burton, JRadioButton rallybird, JRadioButton alltrack, JRadioButton tactic, JRadioButton poker, 
							JRadioButton reckoner, JRadioButton process, JRadioButton yeasayer, JRadioButton ruler, JRadioButton cartel, JRadioButton griffon)
	{
		this.shop = shop;					// Assign ski shop
		this.burton = burton;				// Assign burton radio button
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
		// If Burton brand radio button is selected, display models
		if (burton.isSelected())
		{
			// Display burton models
			process.setVisible(true);
			yeasayer.setVisible(true);
			ruler.setVisible(true);
			cartel.setVisible(true);
			// Set brand filter
			shop.setBrandFilter("Burton");

			// Hide other models
			rallybird.setVisible(false);
			alltrack.setVisible(false);
			tactic.setVisible(false);
			poker.setVisible(false);
			reckoner.setVisible(false);
			griffon.setVisible(false);
		}
	}
}