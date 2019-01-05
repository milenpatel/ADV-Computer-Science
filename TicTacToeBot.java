import java.util.Scanner;
public class Board {
String[ ][ ] board;
int playerMoves=0, oneAwayX, oneAwayY, myOneAwayX, myOneAwayY, lastX, lastY, scenario;
Scanner userInput = new Scanner(System.in);
boolean playersTurn, gameOver=false, playerGoesFirst;
public Board() {
	board = new String[3][3];
	System.out.println("Who Gets to Go First? Type 'player' or 'computer'");
	if (userInput.nextLine().equals("player")) {playersTurn=true; playerGoesFirst=true;}
	else {playersTurn=false; playerGoesFirst=false;}
	for (int r=0; r<board.length;r++) {
		for(int c=0; c<board[1].length;c++) {
			board[r][c]="[ ]";
		}
	}
}
private void display() {
	System.out.println("");
	for (int r=0; r<board.length;r++) {
		for(int c=0; c<board[1].length;c++) {
			System.out.print(board[r][c]);
		} System.out.print(" || ["+r+","+"0]"  +  "["+r+","+"1]" + "["+r+","+"2]");
		System.out.println();
	}
}
public void start() {
	while (!gameOver){
		if (playersTurn) 
			playerTurn();
		if (!playersTurn) 
			computerTurn();
	}
	System.out.println("Total Player Moves: " + playerMoves);
	display();
}
private void playerTurn() {
display();
System.out.println("Enter the X position of where you want to go");
int xPos = userInput.nextInt();
if (xPos<0 || xPos>2) {System.out.println("Out of Bonds"); return;}//Make sure the user input is in the bounds
System.out.println("Enter the Y position of where you want to go");
int yPos = userInput.nextInt();
if (yPos<0 || yPos>2) {System.out.println("Out of Bonds"); playerTurn();}//Make sure the user input is in the bounds
if (board[xPos][yPos].equals("[ ]")) {makeMove(xPos,yPos,"[X]"); playerMoves++; playersTurn=false; checkGame(); return;}
System.out.println("Try Again...There was already a piece here");
}
private void checkGame() {
	//Top Row
	if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]) && board[0][0].equals("[X]")) { gameOver=true; System.out.println("Player Wins"); return;} //Player wins
	if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]) && board[0][0].equals("[O]")) { gameOver=true; System.out.println("Computer Wins"); return;} //Computer wins
	//Middle Row
	if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]) && board[1][0].equals("[X]")) { gameOver=true; System.out.println("Player Wins"); return;} //Player Wins
	if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]) && board[1][0].equals("[O]")) { gameOver=true; System.out.println("Computer Wins"); return;} //Computer Wins
	//Bottom Row
	if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]) && board[2][0].equals("[X]")) { gameOver=true; System.out.println("Player Wins"); return;} //Player Wins	
	if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]) && board[2][0].equals("[O]")) { gameOver=true; System.out.println("Computer Wins"); return;} //Computer Wins	
	//Top Down
	if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && board[0][0].equals("[X]")) {gameOver=true; System.out.println("Player Wins"); return;} //Player Wins
	if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && board[0][0].equals("[O]")) {gameOver=true; System.out.println("Computer Wins"); return;} //Computer Wins
	//Middle Down
	if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) && board[0][1].equals("[X]")) {gameOver=true; System.out.println("Player Wins"); return;} //Player Wins
	if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) && board[0][1].equals("[O]")) {gameOver=true; System.out.println("Computer Wins"); return;} //Computer Wins
	//Right Down
	if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]) && board[0][2].equals("[X]")) {gameOver=true; System.out.println("Player Wins"); return;} //Player Wins
	if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]) && board[0][2].equals("[O]")) {gameOver=true; System.out.println("Computer Wins"); return;} //Computer Wins
	//Diagonal Left
	if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[0][0].equals("[X]")) {gameOver=true; System.out.println("Player Wins"); return;} //Player Wins
	if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[0][0].equals("[O]")) {gameOver=true; System.out.println("Computer Wins"); return;} //Computer Wins
	//Diagonal Right
	if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && board[0][2].equals("[X]")) {gameOver=true; System.out.println("Player Wins"); return;} //Player Wins
	if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && board[0][2].equals("[O]")) {gameOver=true; System.out.println("Computer Wins"); return;} //Computer Wins
	//See if the game board is full. If it is full then call it a tie
	for (String[ ] s:board) {
		for (String r: s) {
			if(r=="[ ]") {gameOver=false; return;}
		}
	}
	gameOver=true;
	System.out.println("Tie Game");
}
private void makeMove(int xPos, int yPos, String toBeEntered) {
if(board[xPos][yPos]=="[ ]") {board[xPos][yPos]=toBeEntered; if(toBeEntered.equals("[X]")) {lastX=xPos; lastY=yPos;}} 
}
private void computerTurn() { 
playersTurn = true;
if (playerMoves==0) {makeMove(0,0,"[O]"); checkGame(); return;}
if (couldIWininOneMove(board)) {makeMove(myOneAwayX,myOneAwayY,"[O]");checkGame(); return;}
if (isPlayerOneStepAway(board)) {makeMove(oneAwayX,oneAwayY,"[O]");checkGame(); return;}
if (scenario==1) {
	scenario=-1;
	if(board[0][2].equals("[ ]")) {makeMove(0,2,"[O]"); return;}
	if(board[2][0].equals("[ ]")) {makeMove(2,0,"[O]"); return;}
	if(board[2][2].equals("[ ]")) {makeMove(2,2,"[O]"); return;}
}


if (playerGoesFirst) {
	playerGoesFirst=false;
	//If they go in a corner
	if((lastX==0 && lastY==0)||(lastX==2 && lastY==0)||(lastX==2 && lastY==0)||(lastX==2 && lastY==0)) {makeMove(1,1,"[O]"); return;}
	//If they go in the middle
	if(lastX==1 && lastY==1) {makeMove(0,0,"[O]"); scenario=1;return; }
	//If they go on an edge
	if((lastX==0 && lastY==1)||(lastX==1 && lastY==0)||(lastX==1 && lastY==2)||(lastX==2 && lastY==1)) {makeMove(1,1,"[O]"); return;}
}

if(board[0][2].equals("[ ]")) {makeMove(0,2,"[O]"); return;}
if(board[2][0].equals("[ ]")) {makeMove(2,0,"[O]"); return;}
if(board[2][2].equals("[ ]")) {makeMove(2,2,"[O]"); return;}


//Place closest to one of the players pieces
for (int r=0; r<3; r++) {
for (int c=0; c<3; c++) {
if (board[r][c].equals("[X]")) {
	if(board[1][1].equals("[ ]")) {makeMove(1,1,"[O]"); checkGame(); return;}//Try to go in the middle
	if(c<2 && board[r][c+1].equals("[ ]")) {makeMove(r,c+1,"[O]"); checkGame(); return;}//Try to go right
	if(c>0 && board[r][c-1].equals("[ ]")) {makeMove(r,c-1,"[O]"); checkGame(); return;}//Try to go left
	if(r<2 && board[r+1][c].equals("[ ]")) {makeMove(r+1,c,"[O]"); checkGame(); return;} //Try to go below
	if(r>0 && board[r-1][c].equals("[ ]")) {makeMove(r-1,c,"[O]"); checkGame(); return;}//Try to go above
}}}
checkGame(); return;
}
private boolean couldIWininOneMove(String[ ][ ] board) {
	myOneAwayX=-1; 	myOneAwayY=-1;
	if((board[0][0].equals(board[0][1]))&&(board[0][0].equals("[O]"))&&(board[0][2].equals("[ ]"))) {myOneAwayX=0; myOneAwayY=2; return true;}	//First two on the top row: Tested	
	if((board[0][1].equals(board[0][2]))&&(board[0][1].equals("[O]"))&&(board[0][0].equals("[ ]"))) {myOneAwayX=0 ; myOneAwayY=0 ;return true;}//Second two on the top row: Tested	
	if((board[0][0].equals(board[0][2]))&&(board[0][0].equals("[O]"))&&(board[0][1].equals("[ ]"))) {myOneAwayX=0 ; myOneAwayY=1 ;return true;}//First and third on the top row: Tested	
	if((board[1][0].equals(board[1][1]))&&(board[1][0].equals("[O]"))&&(board[1][2].equals("[ ]"))) {myOneAwayX=1 ; myOneAwayY=2 ;return true;}//First two on the second row: Tested	
	if((board[1][1].equals(board[1][2]))&&(board[1][1].equals("[O]"))&&(board[1][0].equals("[ ]"))) {myOneAwayX=1 ; myOneAwayY=0 ;return true;}//Second two on the second row: Tested	
	if((board[1][0].equals(board[1][2]))&&(board[1][0].equals("[O]"))&&(board[1][1].equals("[ ]"))) {myOneAwayX=1 ; myOneAwayY=1 ;return true;}//First and third on the second row: Tested	
	if((board[2][0].equals(board[2][1]))&&(board[2][0].equals("[O]"))&&(board[2][2].equals("[ ]"))) {myOneAwayX=2 ; myOneAwayY=2 ;return true;}//First two on the bottom row: Tested	
	if((board[2][1].equals(board[2][2]))&&(board[2][1].equals("[O]"))&&(board[2][0].equals("[ ]"))) {myOneAwayX=2 ; myOneAwayY=0 ;return true;}//Second two on the bottom row: Tested	
	if((board[2][0].equals(board[2][2]))&&(board[2][0].equals("[O]"))&&(board[2][1].equals("[ ]"))) {myOneAwayX=2 ; myOneAwayY=1 ;return true;}//First and third on the bottom row: Tested	
	if((board[0][0].equals(board[1][0]))&&(board[0][0].equals("[O]"))&&(board[2][0].equals("[ ]"))) {myOneAwayX=2 ; myOneAwayY=0 ;return true;}//First two on the left column: Tested	
	if((board[1][0].equals(board[2][0]))&&(board[1][0].equals("[O]"))&&(board[0][0].equals("[ ]"))) {myOneAwayX=0 ; myOneAwayY=0 ;return true;}//Second and third on the left column: Tested	
	if((board[0][0].equals(board[2][0]))&&(board[0][0].equals("[O]"))&&(board[1][0].equals("[ ]"))) {myOneAwayX=1 ; myOneAwayY=0 ;return true;}//First and third on the left column: Tested
	if((board[0][1].equals(board[1][1]))&&(board[0][1].equals("[O]"))&&(board[2][1].equals("[ ]"))) {myOneAwayX=2 ; myOneAwayY=1 ;return true;}//First two on the middle column: Tested	
	if((board[1][1].equals(board[2][1]))&&(board[1][1].equals("[O]"))&&(board[0][1].equals("[ ]"))) {myOneAwayX=0 ; myOneAwayY=1 ;return true;}//Second and third on the middle column: Tested	
	if((board[0][1].equals(board[2][1]))&&(board[0][1].equals("[O]"))&&(board[1][1].equals("[ ]"))) {myOneAwayX=1 ; myOneAwayY=1 ;return true;}//First and third on the middle column: Tested	
	if((board[0][2].equals(board[1][2]))&&(board[0][2].equals("[O]"))&&(board[2][2].equals("[ ]"))) {myOneAwayX=2 ; myOneAwayY=2 ;return true;}//First two on the right column: Tested	
	if((board[1][2].equals(board[2][2]))&&(board[1][2].equals("[O]"))&&(board[0][2].equals("[ ]"))) {myOneAwayX=0 ; myOneAwayY=2 ;return true;}//Second and third on the right column: Tested	
	if((board[0][2].equals(board[2][2]))&&(board[0][2].equals("[O]"))&&(board[1][2].equals("[ ]"))) {myOneAwayX=1 ; myOneAwayY=2 ;return true;}//First and third on the right column: Tested	
	if((board[0][0].equals(board[1][1]))&&(board[0][0].equals("[O]"))&&(board[2][2].equals("[ ]"))) {myOneAwayX=2 ; myOneAwayY=2 ;return true;}//Top left and middle piece: Tested
	if((board[1][1].equals(board[2][2]))&&(board[1][1].equals("[O]"))&&(board[0][0].equals("[ ]"))) {myOneAwayX=0 ; myOneAwayY=0 ;return true;}//Middle and Bottom Right piece: Tested	
	if((board[0][0].equals(board[2][2]))&&(board[0][0].equals("[O]"))&&(board[1][1].equals("[ ]"))) {myOneAwayX=1 ; myOneAwayY=1 ;return true;}//Top left and bottom right: Tested	
	if((board[0][2].equals(board[1][1]))&&(board[0][2].equals("[O]"))&&(board[2][0].equals("[ ]"))) {myOneAwayX=2 ; myOneAwayY=0 ;return true;}//Top Right and middle piece: Tested	
	if((board[1][1].equals(board[2][0]))&&(board[1][1].equals("[O]"))&&(board[0][2].equals("[ ]"))) {myOneAwayX=0 ; myOneAwayY=2 ;return true;}//Middle piece and bottom left piece: Tested
	if((board[2][0].equals(board[0][2]))&&(board[2][0].equals("[O]"))&&(board[1][1].equals("[ ]"))) {myOneAwayX=1 ; myOneAwayY=1 ;return true;}//Bottom left and top right: Tested
	return false;
}
private boolean isPlayerOneStepAway(String[ ][ ] board) {
oneAwayX=-1; oneAwayY=-1;
if((board[0][0].equals(board[0][1]))&&(board[0][0].equals("[X]"))&&(board[0][2].equals("[ ]"))) { oneAwayX=0; oneAwayY=2; return true;}//First two on the top row: Tested
if((board[0][1].equals(board[0][2]))&&(board[0][1].equals("[X]"))&&(board[0][0].equals("[ ]"))) {oneAwayX=0 ; oneAwayY=0 ;return true;}//Second two on the top row: Tested
if((board[0][0].equals(board[0][2]))&&(board[0][0].equals("[X]"))&&(board[0][1].equals("[ ]"))) {oneAwayX=0 ; oneAwayY=1 ;return true;}//First and third on the top row: Tested
if((board[1][0].equals(board[1][1]))&&(board[1][0].equals("[X]"))&&(board[1][2].equals("[ ]"))) {oneAwayX=1 ; oneAwayY=2 ;return true;}//First two on the second row: Tested
if((board[1][1].equals(board[1][2]))&&(board[1][1].equals("[X]"))&&(board[1][0].equals("[ ]"))) {oneAwayX=1 ; oneAwayY=0 ;return true;}//Second two on the second row: Tested
if((board[1][0].equals(board[1][2]))&&(board[1][0].equals("[X]"))&&(board[1][1].equals("[ ]"))) {oneAwayX=1 ; oneAwayY=1 ;return true;}//First and third on the second row: Tested
if((board[2][0].equals(board[2][1]))&&(board[2][0].equals("[X]"))&&(board[2][2].equals("[ ]"))) {oneAwayX=2 ; oneAwayY=2 ;return true;}//First two on the bottom row: Tested
if((board[2][1].equals(board[2][2]))&&(board[2][1].equals("[X]"))&&(board[2][0].equals("[ ]"))) {oneAwayX=2 ; oneAwayY=0 ;return true;}//Second two on the bottom row: Tested
if((board[2][0].equals(board[2][2]))&&(board[2][0].equals("[X]"))&&(board[2][1].equals("[ ]"))) {oneAwayX=2 ; oneAwayY=1 ;return true;}//First and third on the bottom row: Tested
if((board[0][0].equals(board[1][0]))&&(board[0][0].equals("[X]"))&&(board[2][0].equals("[ ]"))) {oneAwayX=2 ; oneAwayY=0 ;return true;}//First two on the left column: Tested
if((board[1][0].equals(board[2][0]))&&(board[1][0].equals("[X]"))&&(board[0][0].equals("[ ]"))) {oneAwayX=0 ; oneAwayY=0 ;return true;}//Second and third on the left column: Tested
if((board[0][0].equals(board[2][0]))&&(board[0][0].equals("[X]"))&&(board[1][0].equals("[ ]"))) {oneAwayX=1 ; oneAwayY=0 ;return true;}//First and third on the left column: Tested
if((board[0][1].equals(board[1][1]))&&(board[0][1].equals("[X]"))&&(board[2][1].equals("[ ]"))) {oneAwayX=2 ; oneAwayY=1 ;return true;}//First two on the middle column: Tested
if((board[1][1].equals(board[2][1]))&&(board[1][1].equals("[X]"))&&(board[0][1].equals("[ ]"))) {oneAwayX=0 ; oneAwayY=1 ;return true;}//Second and third on the middle column: Tested
if((board[0][1].equals(board[2][1]))&&(board[0][1].equals("[X]"))&&(board[1][1].equals("[ ]"))) {oneAwayX=1 ; oneAwayY=1 ;return true;}//First and third on the middle column: Tested
if((board[0][2].equals(board[1][2]))&&(board[0][2].equals("[X]"))&&(board[2][2].equals("[ ]"))) {oneAwayX=2 ; oneAwayY=2 ;return true;}//First two on the right column: Tested
if((board[1][2].equals(board[2][2]))&&(board[1][2].equals("[X]"))&&(board[0][2].equals("[ ]"))) {oneAwayX=0 ; oneAwayY=2 ;return true;}//Second and third on the right column: Tested
if((board[0][2].equals(board[2][2]))&&(board[0][2].equals("[X]"))&&(board[1][2].equals("[ ]"))) {oneAwayX=1 ; oneAwayY=2 ;return true;}//First and third on the right column: Tested
if((board[0][0].equals(board[1][1]))&&(board[0][0].equals("[X]"))&&(board[2][2].equals("[ ]"))) {oneAwayX=2 ; oneAwayY=2 ;return true;}//Top left and middle piece: Tested
if((board[1][1].equals(board[2][2]))&&(board[1][1].equals("[X]"))&&(board[0][0].equals("[ ]"))) {oneAwayX=0 ; oneAwayY=0 ;return true;}//Middle and Bottom Right piece: Tested
if((board[0][0].equals(board[2][2]))&&(board[0][0].equals("[X]"))&&(board[1][1].equals("[ ]"))) {oneAwayX=1 ; oneAwayY=1 ;return true;}//Top left and bottom right: Tested
if((board[0][2].equals(board[1][1]))&&(board[0][2].equals("[X]"))&&(board[2][0].equals("[ ]"))) {oneAwayX=2 ; oneAwayY=0 ;return true;}//Top Right and middle piece: Tested
if((board[1][1].equals(board[2][0]))&&(board[1][1].equals("[X]"))&&(board[0][2].equals("[ ]"))) {oneAwayX=0 ; oneAwayY=2 ;return true;}//Middle piece and bottom left piece: Tested
if((board[2][0].equals(board[0][2]))&&(board[2][0].equals("[X]"))&&(board[1][1].equals("[ ]"))) {oneAwayX=1 ; oneAwayY=1 ;return true;}//Bottom left and top right: Tested
return false;
}
}
//Players will be X's
//Computers will be O's
