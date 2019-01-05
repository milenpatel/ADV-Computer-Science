import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Homescreen extends JFrame{
	public static boolean shouldThisPageBeHidden = false;
	private static final long serialVersionUID = 1L;
	private JButton Play, Credits, Help;

	public Homescreen() {
	super("Main Menu");//Title of panel
	setSize(main.ScreenSizeX,main.ScreenSizeY);
	GridBagLayout myLayout = new GridBagLayout();
	setLayout(myLayout);
	GridBagConstraints gbc = new GridBagConstraints();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setBackground(main.backgroundColor);
	Play = new JButton("Play");
	gbc.gridx=0;
	gbc.gridy=0;
	gbc.ipadx=200;
	gbc.ipady=100;
	gbc.gridwidth = 2;
	add(Play, gbc);	
	
	
	Credits = new JButton("Credits");
	gbc.gridwidth = 1;
	gbc.gridx=0;
	gbc.gridy=1;
	gbc.ipady=50;
	add(Credits, gbc);
	
	Help = new JButton("Help");
	gbc.ipady=50;
	gbc.gridx=1; gbc.gridy=1; add(Help, gbc);
	
	
	thehandler Zhandler = new thehandler();
	Play.addActionListener(Zhandler);
	Credits.addActionListener(Zhandler);
	Help.addActionListener(Zhandler);
	
	setVisible(true);
	}//End of constructor
	
	private class thehandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
		if(event.getSource()==Credits) {CreditsPage userCredits = new CreditsPage();userCredits.setVisible(true);}
		if(event.getSource()==Help) {HelpPage userHelp = new HelpPage();userHelp.setVisible(true);}
		if(event.getSource()==Play) {
			GamePage actualgame = new GamePage(); actualgame.setVisible(true);
			}

	}
	//event.getActionCommand() will tell you what was in a label when the button was clicked
	

}}//End of class
