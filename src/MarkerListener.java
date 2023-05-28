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
 * Display Marker models under the "Models" menu if selected
 */

public class MarkerListener implements ActionListener
{
	private SkiShop shop;					// MarkerListener HAS-A Ski shop
	private JRadioButton marker;			// MarkerListener HAS-A radio button for marker products
	private JRadioButton rallybird;			// MarkerListener HAS-A radio button for rallybird model
	private JRadioButton alltrack;			// MarkerListener HAS-A radio button for alltrack model
	private JRadioButton tactic;			// MarkerListener HAS-A radio button for tactic model
	private JRadioButton poker;				// MarkerListener HAS-A radio button for poker model
	private JRadioButton reckoner;			// MarkerListener HAS-A radio button for poker model
	private JRadioButton process;			// MarkerListener HAS-A radio button for poker model
	private JRadioButton yeasayer;			// MarkerListener HAS-A radio button for poker model
	private JRadioButton ruler;				// MarkerListener HAS-A radio button for poker model
	private JRadioButton cartel;			// MarkerListener HAS-A radio button for poker model
	private JRadioButton griffon;			// MarkerListener HAS-A radio button for poker model

	public MarkerListener(SkiShop shop, JRadioButton marker, JRadioButton rallybird, JRadioButton alltrack, JRadioButton tactic, JRadioButton poker, 
							JRadioButton reckoner, JRadioButton process, JRadioButton yeasayer, JRadioButton ruler, JRadioButton cartel, JRadioButton griffon)
	{
		this.shop = shop;					// Assign ski shop
		this.marker = marker;				// Assign marker radio button
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
		// If marker brand radio button is selected, display models
		if (marker.isSelected())
		{
			// Display marker models
			griffon.setVisible(true);
			// Set brand filter
			shop.setBrandFilter("Marker");

			// Hide other models
			rallybird.setVisible(false);
			alltrack.setVisible(false);
			tactic.setVisible(false);
			poker.setVisible(false);
			reckoner.setVisible(false);
			process.setVisible(false);
			yeasayer.setVisible(false);
			ruler.setVisible(false);
			cartel.setVisible(false);
		}
	}
}