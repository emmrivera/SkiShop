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
 * Display Rossignol models under the "Models" menu if selected
 */

public class RossignolListener implements ActionListener
{
	private SkiShop shop;					// RossignolListener HAS-A Ski shop
	private JRadioButton rossignol;			// RossignolListener HAS-A radio button for rossignol products
	private JRadioButton rallybird;			// RossignolListener HAS-A radio button for rallybird model
	private JRadioButton alltrack;			// RossignolListener HAS-A radio button for alltrack model
	private JRadioButton tactic;			// RossignolListener HAS-A radio button for tactic model
	private JRadioButton poker;				// RossignolListener HAS-A radio button for poker model
	private JRadioButton reckoner;			// RossignolListener HAS-A radio button for poker model
	private JRadioButton process;			// RossignolListener HAS-A radio button for poker model
	private JRadioButton yeasayer;			// RossignolListener HAS-A radio button for poker model
	private JRadioButton ruler;				// RossignolListener HAS-A radio button for poker model
	private JRadioButton cartel;			// RossignolListener HAS-A radio button for poker model
	private JRadioButton griffon;			// RossignolListener HAS-A radio button for poker model

	public RossignolListener(SkiShop shop, JRadioButton rossignol, JRadioButton rallybird, JRadioButton alltrack, JRadioButton tactic, JRadioButton poker, 
							JRadioButton reckoner, JRadioButton process, JRadioButton yeasayer, JRadioButton ruler, JRadioButton cartel, JRadioButton griffon)
	{
		this.shop = shop;					// Assign ski shop
		this.rossignol = rossignol;			// Assign rossignol radio button
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
		// If rossignol brand radio button is selected, display models
		if (rossignol.isSelected())
		{
			// Display rossignol models
			rallybird.setVisible(true);
			alltrack.setVisible(true);
			tactic.setVisible(true);
			poker.setVisible(true);
			// Set brand filter
			shop.setBrandFilter("Rossignol");

			// Hide other models
			reckoner.setVisible(false);
			process.setVisible(false);
			yeasayer.setVisible(false);
			ruler.setVisible(false);
			cartel.setVisible(false);
			griffon.setVisible(false);
		}
	}
}