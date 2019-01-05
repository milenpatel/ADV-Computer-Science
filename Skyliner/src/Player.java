public class Player {
private int playerBalance;
private String playerName;
private int energy = 0;
public Player(int playerBalance, String playerName) {
	if (playerBalance<0){playerBalance=0;}else{this.playerBalance = playerBalance;}
	this.playerName = playerName;
}



public int getBalance() {return playerBalance;}
public void increaseBalance(int amount) {playerBalance+=amount;}
public void decreaseBalance(int amount) {if (amount>playerBalance) {System.out.println("Error: Insufficient Balance");} else {	playerBalance -= amount;}}
public String getPlayerName() {return playerName;}
public String toString() {return "Name: " + playerName + " Balance: " + playerBalance;}


}
