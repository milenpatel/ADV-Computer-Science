import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GamePage extends JFrame{
private JButton changeBalance, goToSlotMachine;
private JLabel userBalance;
private Player gamePlayer;
	
public GamePage() {
super("Game");
this.getContentPane().setBackground(main.backgroundColor);
this.setSize(main.ScreenSizeX,main.ScreenSizeY);
int initialBalance=Integer.parseInt(JOptionPane.showInputDialog("Enter your initial balance?"));
String playerInputForName=JOptionPane.showInputDialog("What is your name?");
this.gamePlayer=new Player(initialBalance,playerInputForName);

GridBagLayout gamePageLayout = new GridBagLayout();
setLayout(gamePageLayout);
GridBagConstraints constraints = new GridBagConstraints();
setVisible(true);

changeBalance= new JButton("Change Balance");
constraints.gridx=1;
constraints.gridy=0;
add(changeBalance,constraints);

userBalance = new JLabel("Balance: $" + Integer.toString(gamePlayer.getBalance()));
constraints.gridx=0;
constraints.gridy=0;
add(userBalance,constraints);

buttonHandler clicker = new buttonHandler();
changeBalance.addActionListener(clicker);

goToSlotMachine = new JButton("Slot Machine");
constraints.gridx=0;
constraints.gridy=1;
add(goToSlotMachine, constraints);
goToSlotMachine.addActionListener(clicker);
}
class buttonHandler implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==changeBalance) {gamePlayer.increaseBalance(5); userBalance.setText("Balance: $" + Integer.toString(gamePlayer.getBalance()));}
		if(e.getSource()==goToSlotMachine) {System.out.println("rikiki");}
	}
	
}
}
