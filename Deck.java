package javaFinalProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Deck {

	//Represents the deck of cards
	private List<Card> cards = new ArrayList<Card>();
	
	private List<String> suits = Arrays.asList("Clubs", "Diamonds", "Hearts", "Spades"); 
	private List<String> names = Arrays.asList("Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace");
		
	//Used to create the full name of the cards by appending the elements in the names and suits lists to the StringBuilder object
	private StringBuilder buildCardNames = new StringBuilder(); 
	
	public Deck() {
		
		//Adds 52 cards with their full names and values to the deck
		for (String suit : suits) {  
				int valueCounter = 2;
				for (String name : names) { //Loops through the names list for each suit
					buildCardNames.setLength(0); //Clears the StringBuilder object to append a new card name to it in each iteration of the loop
					buildCardNames.append(name + " of " + suit); //Creates the full name of a card by appending a name and a suit element to the StringBuilder object
					cards.add(new Card(buildCardNames.toString(), valueCounter)); //Instantiates an object of the Card class in each iteration of the loop creating 52 cards
					valueCounter++;
				}
		}  
		
	}
	
	//Shuffles the card in the deck
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	//Draws a card from the deck
	public Card draw() {
		Card card = this.cards.remove(0); //Removes the top card from the deck and returns the card
		return card;
	}

	//Gets the size of the list of Card
	public int getListSize() {
		return cards.size();
	}

}
