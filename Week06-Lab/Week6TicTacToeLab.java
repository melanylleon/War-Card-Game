
package week6;

import java.util.Scanner;

public class Week6TicTacToeLab {

	// This Lab requires you to program a simple game of Tic Tac Toe
		//
		// 		 Note:  there are many ways to implement this game.  Use what 
		//		  		you have already learned.  You have the tools to implement
		//		  		this game.  
		//
		// Rules:  
		//		- Tic Tac Toe is a 2-player game played on a 3x3 grid.  
		//
		//		- One player usually plays "X"s and the other player plays "O"s.
		//
		// 		- In our version of the game, "X"s will always start.
		//
		//		- Players will alternate turns.
		//
		// 		- The game will end when one of the conditions is true:
		//				1. A player gets three squares in a row 
		//				2. A player gets three squares in a column
		//				3. A player gets three squares in either diagonal
		//				4. Every square is filled in, but no player has achieved 
		//					conditions 1,2, or 3 as described above --> A Draw!
		//
		//		- A player can win on turn 5, 6, 7, 8, or 9 (start checking for winners on or after turn 5)
		//
		//		- Use the Scanner to input the users choice of square -- one suggestion is  
		//				to create numbers within the square, and then have the user choose 
		//				that integer (1-9) to choose the location.
		//
		//		- One way to display the game board would be as follows:
		//				+---+---+---+       to		+---+---+---+		+---+---+---+		+---+---+---+
		//				| 1 | 2 | 3 |	   find		|---|---|---|		| | | | | | |		| \ |   | / |
		//				+---+---+---+	   a win	+---+---+---+		+---+---+---+		+---+---+---+
		//				| 4 | 5 | 6 |	-- look-->	|---|---|---|	&	| | | | | | |   & 	|   | X |   |
		//				+---+---+---+	 at these	+---+---+---+		+---+---+---+		+---+---+---+
		//				| 7 | 8 | 9 |	8 patterns	|---|---|---|		| | | | | | |		| / |   | \ |
		//				+---+---+---+		        +---+---+---+		+---+---+---+		+---+---+---+
			
			
		// Start with these steps:
		//
		//		1. Create a class with a main method -- this Lab can be implemented in just one class.
		//				
		//				Alternatively, you could create an object with it's own methods. 
		//				(e.g. GameBoard.java)
		//
		//		2. You will need to declare a gameBoard.  
		//
		//				As shown above, Tic Tac Toe is played on a 3x3 grid that has 9 spaces. 
		//
		//					a. One suggestion is to create an array of length 9 to represent the board:
		//
		//						For example:  String[] gameBoard = new String[9]; 
		//
		//							i. Just remember that arrays are 0 based, so to access the grid, 
		//							the index would go from 0-8.  
		//
		//							ii. Wins can occur in 8 ways (see above).
		//								For example: A horizontal win would be found by 
		//								looking at the contents of: 
		//									gameBoard[0] & gameBoard[1] & gameBoard[2] 
		//									gameBoard[3] & gameBoard[4] & gameBoard[5] 
		//									gameBoard[6] & gameBoard[7] & gameBoard[8] 
		//
		//					b. Another option for the gameBoard would be a 2d array -- This option might be
		//						is a bit more challenging!  
		//
		//						For example:  String[][] gameBoard = new String[3][3];
		//					
		//							i. Just remember that arrays are 0 based, so to access the grid, 
		//							the index would go from 0-2 in two directions.  
		//
		//							ii. Wins can occur in 8 ways.  A horizontal win would be comparing:  
		//									gameBoard[0][0] & gameBoard[0][1] & gameBoard[0][2] 
		// 
		//		3.  Implement the rules as listed above.  
		//
		//		4.  You might want to have the following methods:
		//					a. display() -- to print the gameBoard
		//					b. checkWinStatus() -- to check if a player has won
		//					c. initialize() -- to set up your new gameBoard
		//			
		//		5.  Reminder:  There is no one way to implement this game.
		//		
		//	
		
		// START YOUR IMPLEMENTATION BELOW THIS LINE
	
	
		static Scanner s = new Scanner(System.in);
	
		//Creates an object of the GameBoard class
		static GameBoard gameBoard = new GameBoard();
		
		static int i = 0;
		static int positionOnBoard = 0;

		public static void main(String[] args) {
			//Displays the game board with the numbers indicating the position on the board, the instructions on how to win the game and 
			//3 more game boards with the patterns needed to win the game
			gameBoard.display();
			System.out.println();
			
			char player;
				
			//Loops 10 times to represent the 9 turns in the game and once more to print that it's a draw if none of the players wins the game	
			while (i <= 9) {
				//If the players pick all of the positions on the board and neither gets one of the 8 patterns needed to win, it's a draw 
				if (i == 9) {
					System.out.println("It's a Draw.");
					i++;
				//Player X's turns
				} else if (i % 2 == 0) {
					player = 'X';
					playerTurns(player);
				//Player O's turns
				} else {
						player = 'O';
						playerTurns(player);
				} 	
			}
		}
	
	public static void playerTurns(char player) {
		System.out.println("Player " + player +", pick the position on the board: ");
		positionOnBoard = s.nextInt();
		//Initializes the gameBoard array with the letter of the player at the position chosen by the player
		gameBoard.initialize(player, positionOnBoard);
		//Starting at turn 5, it checks if the player playing on their turn is the winner. This is done by checking if the player got one of the 8 patterns.
		if (i >= 4) {
			i = gameBoard.checkWinStatus(player, i);
			if (i == 10) {
				System.out.println("Player " + player + " is the winner!");
			}
		}
		i++;
	}
}
