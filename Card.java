package javaFinalProject;

public class Card {

	private String name;
	private int value;
	
	//Initializes an object of the Card class
	public Card(String name, int value) { 
		this.name = name;
		this.value = value;	
	}
	
	//Describes a card's name and its value 
	public void describe() {
		System.out.print(name + ", " + value);
	}

	//Gets the name of the card
	public String getName() {
		return name;
	}

	//Sets the card name 
	public void setName(String name) {
		this.name = name;
	}

	//Gets the value of the card
	public int getValue() {
		return value;
	}

	//Sets the value of the card
	public void setValue(int value) {
		this.value = value;
	}
	
	
}
