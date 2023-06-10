package javaFinalProject;

import java.util.List;
import java.util.ArrayList;

public class Player {
	
	//Represents the cards each player has in their hand after the cards are dealt
	List<Card> hand = new ArrayList<Card>();
	int score;
	String name;
	
	//Initializes an object of the Player class with a player's name and score
	public Player(String name) {
		this.name = name; 
		this.score = 0; 
	}
	
	//Describes the cards in a player's hand
	public void describe() {
		System.out.println(this.name + "'s Cards:" );
		for (Card card : this.hand) {
			card.describe();
		}
	}
	
	//Removes and returns a card at the top of a player's hand
	public Card flip() {
		Card card = this.hand.remove(0);
		return card;	
	}
	
	//Draws a card from the deck and adds it to the hand list
	public void draw(Deck deck) {
		hand.add(deck.draw());
	}
	
	//Increments the score of a player by 1 point
	public int incrementScore() {
		return score += 1;
	}
	
	//Gets the score of a player
	public int getScore() {
		return this.score;
	}
	
	//Gets the amount of cards in a player's hand
	public int getCardsInHandSize() {
		return hand.size();
	}
	
}
