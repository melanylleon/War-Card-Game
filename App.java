package javaFinalProject;

public class App {

	public static void main(String[] args) {
		
		/*
		 * 	War Card Game Rules
		 *  This project is a simpler version of the war card game. It has 2 players and a deck of 52 cards. Each player will be dealt their cards.
		 *  There will be 26 turns and each player will flip the top card in their hand for every turn. Whichever has the highest card value will win  
		 *  for that turn and they will get 1 point added to their score. After they have gone through the 26 turns, the final scores will be compared
		 *  and the player with the highest score will win the game. If their final scores are the same, it's a tie.
		 *  
		 *  Steps Needed to Write the Code
		 *  For this project, I created a Card class, a Deck class, a Player class, and an App class that has the main method in it. The Card class is used
		 *  to create a card and describe it using its name and its value. The Deck class is used to create a deck of cards using a list of Card. It shuffles 
		 *  the cards in the deck, and draws the top card from the deck. The Player class is used to describe the cards each player has in their hand after they
		 *  are dealt and it flips the card at the top of their hand. It also draws a card from the deck to put it in the player's hand and it increments and gets 
		 *  the score of each player. The App class is used to create the 2 players and the deck of cards. The first for loop is used to draw the cards from the deck
		 *  and put them in each player's hand. The second for loop is used to have each player flip the card at the top of their hand and compare the value of each 
		 *  card to determine who wins each turn. Whoever wins the turn gets a point added to their score and if they are tied neither one gets a point. The scores are 
		 *  printed for each round. Once they run out of cards(go through all 26 turns), the final scores are compared and the winner is printed. If it's a tie, then it 
		 *  prints it's a draw.
		 *
		 * */
		
		//Instantiates an object from the Deck class
		Deck deck = new Deck();

		//Instantiates two objects from the Player class
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");

		Card cardPlayer1;
		Card cardPlayer2;
		
		int deckSize = deck.getListSize();		
		int handSize;
		
		//Calls the shuffle method to shuffle the deck of cards
		deck.shuffle();
				
		//Draws the 52 cards in the deck to each player
		for (int drawFromDeck = 0; drawFromDeck < deckSize; drawFromDeck++) {
			if (drawFromDeck % 2 == 0) {
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}
		
		System.out.println("War Card Game");
		
		//The amount of cards in each players hand: 26
		handSize = player1.getCardsInHandSize();
		
		//Each player flips a card from their hand at the same time, they do this 26 times to go through the total of 52 cards
		for (int turn = 0; turn < handSize; turn++) {
			cardPlayer1 = player1.flip();
			cardPlayer2 = player2.flip();

			System.out.println("\nCard Flipped By Each Player");
			System.out.print("Player 1's Card: ");
			cardPlayer1.describe();    //Shows the full name and value of player 1's card
			System.out.print("\nPlayer 2's Card: ");
			cardPlayer2.describe();    //Shows the full name and value of player 2's card

			//Compares the values of each player's card, the score is incremented by 1 point for the player with the highest card value
			if (cardPlayer1.getValue() > cardPlayer2.getValue()) {
				player1.incrementScore();
				System.out.println("\n\nPlayer 1 wins this turn.\n");
			} else if (cardPlayer2.getValue() > cardPlayer1.getValue()) {
				player2.incrementScore();
				System.out.println("\n\nPlayer 2 wins this turn.\n");
			} else {   //If there is a tie, neither one of the players gets a point
				System.out.println("\n\nIt was a tie in this turn.\n");
			}

			//Gets and prints the score of each player for each turn 
			System.out.println("Scoreboard");
			System.out.printf("Player 1's score - %d\nPlayer 2's score - %d %n%n%n%n", player1.getScore(), player2.getScore());

		}

		//Gets and prints the final score of each player
		System.out.println("Final Scores");
		System.out.printf("Player 1's score - %d\nPlayer 2's score - %d %n", player1.getScore(), player2.getScore());

		//Compares the final scores and prints the winner
		if (player1.getScore() > player2.getScore()) {
			System.out.println("Player 1 is the winner!");
		} else if (player2.getScore() > player1.getScore()) {
			System.out.println("Player 2 is the winner!");
		} else { //If its a tie, it prints "Its a Draw."
			System.out.println("It's a Draw."); 
		}
		
	}
}
