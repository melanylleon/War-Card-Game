# War Card Game
![GitHub contributors](https://img.shields.io/github/contributors/melanylleon/War-Card-Game)
![GitHub commit activity (branch)](https://img.shields.io/github/commit-activity/t/melanylleon/War-Card-Game)
![GitHub issues](https://img.shields.io/github/issues/melanylleon/War-Card-Game)
![GitHub](https://img.shields.io/github/license/melanylleon/War-Card-Game)
[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg)](CODE_OF_CONDUCT.md)




##  :star2: About the Project
This is a simple version of the War card game. Two players compare their cards’ values to find the one with the highest score for each turn. After all cards have been compared, whoever has the highest final score wins the game. 

### :space_invader: Tech Stack
- Java

### :dart: Features
- Shuffles the cards in a deck
- Draws the cards to each player
- Compares the card of each player to find the card with the highest value

## :running: Run Locally
Clone the project

``` 
git clone https://github.com/melanylleon/War-Card-Game.git
```
Run on IDE

## :eyes: Usage
This program is an implementation of the War card game. There are two players and a deck of 52 cards. The cards are shuffled and drawn to the players so that each player has 26 cards. On every turn, they compare a card from each player’s hand and whoever has the card with the highest value wins that turn. Once all of the cards have been compared, the final scores determine which player wins the game. The player with the highest final score wins the game. If both players have the same score, it’s declared a draw. 

**Creates the deck of 52 cards**
```java
public Deck() {
		
		
  for (String suit : suits) {  
				int valueCounter = 2;
				for (String name : names) { 
					buildCardNames.setLength(0); 
					buildCardNames.append(name + " of " + suit); 
					cards.add(new Card(buildCardNames.toString(), valueCounter)); 
					valueCounter++;
				}
		}  
		
	}

```
</br>

**Each player flips a card and they are compared to determine which card has the highest value**
```java
		handSize = player1.getCardsInHandSize();
		
		
		for (int turn = 0; turn < handSize; turn++) {
			cardPlayer1 = player1.flip();
			cardPlayer2 = player2.flip();

			System.out.println("\nCard Flipped By Each Player");
			System.out.print("Player 1's Card: ");
			cardPlayer1.describe();    
			System.out.print("\nPlayer 2's Card: ");
			cardPlayer2.describe();    

			if (cardPlayer1.getValue() > cardPlayer2.getValue()) {
				player1.incrementScore();
				System.out.println("\n\nPlayer 1 wins this turn.\n");
			} else if (cardPlayer2.getValue() > cardPlayer1.getValue()) {
				player2.incrementScore();
				System.out.println("\n\nPlayer 2 wins this turn.\n");
			} else {   
				System.out.println("\n\nIt was a tie in this turn.\n");
			}

			System.out.println("Scoreboard");
			System.out.printf("Player 1's score - %d\nPlayer 2's score - %d %n%n%n%n", player1.getScore(), player2.getScore());

		}

```

## :compass: Roadmap

* [ ] Create a feature that let’s you input the number of players and uses that number to deal the cards evenly between them.

## :wave: Contributing
Please feel free to contribute to the project!  

Please see the `CONTRIBUTING.md` file for more information.

## :warning: License
Please see the `LICENSE.txt` file for more information.

# :handshake: Contact

Melany Landaverde Leon - melany.leon0199@gmail.com

Project Link: [https://github.com/melanylleon/War-Card-Game.git]( https://github.com/melanylleon/War-Card-Game.git)




