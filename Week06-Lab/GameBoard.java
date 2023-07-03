package week6;

import java.util.Arrays;
import java.util.List;

public class GameBoard {
	/*
	 * A class that displays the tic tac toe game board with the numbers of the positions that the players can choose from on the board.
	 * The display() method also adds instructions and 3 other game boards with the 8 patterns needed to win the game (shown below).
	 * There is also the checkWinStatus() method that checks if the positions a player has chosen match one of the 8 patterns needed to win. 
	 * The last method initializes a 2D array with the letter representing the player, either X or O, at the position that they chose. The 
	 * elements of the array are used in the checkWinStatus() method to check which player won the game.
	 * 
	 * */

	char[][] gameBoard = new char[3][3];	
	List<String> instructions = Arrays.asList("to", "find", " a win", "-- look-->", "at these", "8 patterns", "          ");
	int evenRowCounter = 0;
	int oddRowCounter = 1;
	int num= 1;

//				The display() method prints out these game boards
//				+---+---+---+       to		+---+---+---+		+---+---+---+		+---+---+---+
//				| 1 | 2 | 3 |	   find		|---|---|---|		| | | | | | |		| \ |   | / |
//				+---+---+---+	   a win	+---+---+---+		+---+---+---+		+---+---+---+
//				| 4 | 5 | 6 |	-- look-->	|---|---|---|	&	| | | | | | |   & 	|   | X |   |
//				+---+---+---+	 at these	+---+---+---+		+---+---+---+		+---+---+---+
//				| 7 | 8 | 9 |	8 patterns	|---|---|---|		| | | | | | |		| / |   | \ |
//				+---+---+---+		        +---+---+---+		+---+---+---+		+---+---+---+
	
	
	//Prints a game board with the numbers indicating the position on the game board that the players can pick and 3 game boards with the patterns needed to win the game
	public void display() { 
		System.out.println("The Game Board and 8 Different Patterns to Win the Game");
		
		for (int numOfRows = 0; numOfRows < 7; numOfRows++) {
			if (numOfRows % 2 == 0) {  //Prints even rows of the game boards
				printPlusSignsAndDashesLine();
			} else {  //Prints odd rows of the game boards
				displayNumBoard();
				displayDashesAndPipesBoards(numOfRows);
				displayDiagonalWinBoard(numOfRows);
			}		 	
		}
	} 
	
	//Prints the even rows of the game boards that are made up of plus signs and dashes
	public void printPlusSignsAndDashesLine() { 
	
		//Prints a row for each of the 4 game boards and instructions in between the first and second game boards
		for (int i = 0; i < 4; i++) {
			//Adds instructions of the game in between the the first and second game board rows
			if (i == 1 && evenRowCounter < 6) {
				displayInstructions(evenRowCounter);
				evenRowCounter += 2;
			//Prints spaces for the last row beneath the instructions of the game
			} else if (i == 1 && evenRowCounter == 6) {
				System.out.print("                ");
			}
			
			//Prints an even row for each of the game boards with spaces in between them except for the first game board's row that doesn't have spaces
			if (i > 0) {
				System.out.print("+---+---+---+     ");
			} else if (i == 0) {
				System.out.print("+---+---+---+");
			}
		}
		
		System.out.println();

	}
	
	//Prints the game board with the numbers of each position the players can pick on the game board
	public void displayNumBoard() { 
		
		System.out.print("| " + num + " | " + (num + 1) + " | " + (num + 2) + " |");
		num += 3; //Starts at the number of the next row
		
		displayInstructions(oddRowCounter);
		oddRowCounter += 2;
	}
	
	//Prints the instructions on how to win the game and spaces before and after the instructions
	public void displayInstructions(int rowNum) { 
		
				createSpacesAroundInstructionStrings(rowNum);
				System.out.print(instructions.get(rowNum));
				createSpacesAroundInstructionStrings(rowNum);
	}
	
	//Prints spaces before and after the instructions to center them between the first and second game board
	public void createSpacesAroundInstructionStrings(int rowNum) {
		double stringPosition;
		int num = 0;
		
		String elementInst = instructions.get(rowNum);
		stringPosition = (14 - elementInst.length()) / 2;
		
		for (int position = 1; position <= 14; position++) {
			while (num <= stringPosition)  {
				System.out.print(" ");
				num++;
			}	
		}
		
		num = 0;
	}
	
	//Prints the second and third game boards with the horizontal and vertical patterns needed to win the game
	public void displayDashesAndPipesBoards(int numOfRow) {
		
		//Prints the row with the & in between them
		if (numOfRow == 3) {
			System.out.print("|---|---|---|  &  | | | | | | |  &  ");
		//Prints the rest of the rows with just spaces in between them
		} else {
			System.out.print("|---|---|---|     ");
			System.out.print("| | | | | | |     ");
		}
	}
	
	//Prints the last game board with the 2 diagonal patterns that a player can get to win the game
	public void displayDiagonalWinBoard(int numOfRow) {
		if (numOfRow == 1) {
			System.out.println("| \\ |   | / |");
		} else if (numOfRow == 3) {
			System.out.println("|   | X |   |");
		} else if (numOfRow == 5){
			System.out.println("| / |   | \\ |");
		}
	}

	//Starting at turn 5, it checks in each turn if the player playing at that turn got one of the 8 patterns needed to win the game
	public int checkWinStatus(char player, int turnNumber) {
		
		int j = 0;
		boolean win = false;
		
		for (int i = 0; i < gameBoard[0].length; i++) {
			//Checks if the players got a win horizontally
			if (gameBoard[i][j] == player && gameBoard[i][j + 1] == player && gameBoard[i][j + 2] == player) {
				win = true;
				i = gameBoard[i].length;
			//Checks if the players got a win vertically
			} else if (gameBoard[j][i] == player && gameBoard[j + 1][i] == player && gameBoard[j + 2][i] == player) {
				win = true;
				i = gameBoard[i].length;
			} 				
		}
		
		//If a player got a win either horizontally or vertically, returns 10 to exit the loop and declares a winner
		if (win) {
			return 10;
		//If a player wins with a diagonal pattern from the top left to the bottom right of the game board, returns 10 to exit the loop and declares a winner
		} else if (gameBoard[j][j] == player && gameBoard[j + 1][j + 1] == player && gameBoard[j + 2][j + 2] == player) {
			return 10;
		//If a player wins with a diagonal pattern from the bottom left to the top right of the game board, returns 10 to exit the loop and declares a winner
		} else if (gameBoard[j + 2][j] == player && gameBoard[j + 1][j + 1] == player && gameBoard[j][j + 2] == player) {
			return 10;
		//If a player does not get any of the 8 patterns, it returns the same turn number, the game keeps going and the next player picks a position on the game board
		} else {
			return turnNumber;
		}
	}
	
	//Initializes the game board array as each player picks a number that indicates the position on the game board
	public void initialize(char player, int positionOnBoard) {

		switch (positionOnBoard) {
			case 1: 
				gameBoard[0][0] = player;
				break;
			case 2: 
				gameBoard[0][1] = player;
				break;
			case 3: 
				gameBoard[0][2] = player;
				break;
			case 4: 
				gameBoard[1][0] = player;
				break;
			case 5: 
				gameBoard[1][1] = player;
				break;
			case 6: 
				gameBoard[1][2] = player;
				break;
			case 7: 
				gameBoard[2][0] = player;
				break;
			case 8: 
				gameBoard[2][1] = player;
				break;
			case 9: 
				gameBoard[2][2] = player;
				break;		
			}
	}
}

