import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//hey there
public class CreditsPage extends JFrame{
private JLabel credits;
private JButton returnButton;
public CreditsPage(){
	super("Credits Page");
	setSize(main.ScreenSizeX,main.ScreenSizeY);

	GridBagLayout creditsPageLayout = new GridBagLayout();
	setLayout(creditsPageLayout);
	GridBagConstraints constraints = new GridBagConstraints();
	
	constraints.gridx=0;
	constraints.gridy=0;
	credits= new JLabel();
	add(credits, constraints);
	credits.setText("The software code for this game was written by Milen Patel starting on November 14th, 2018.");
	
	constraints.gridx=0;
	constraints.gridy=1;
	returnButton = new JButton("Return");
	add(returnButton, constraints);
	
	buttonHandler Ears = new buttonHandler();
	returnButton.addActionListener(Ears);
	getContentPane().setBackground(main.backgroundColor);
}
	
	private class buttonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==returnButton) {setVisible(false);}
		}
	}
	
	
}
