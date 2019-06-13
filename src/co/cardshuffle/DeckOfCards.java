package co.cardshuffle;

import java.util.Random;

public class DeckOfCards {

	public static final int SIZE = 52;
	private final Card[] deckOfCards = new Card[SIZE];

	DeckOfCards() {
		// Start the array at zero so the first card is at the first spot in the array.
		int currentCardIndex = 0;
		// Create a card of each value for each suit.
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deckOfCards[currentCardIndex++] = new Card(suit, rank);
			}
		}
	}
	// Getter for the whole array of cards (whole deck of cards).
	public Card[] getDeckOfCards() {
		return deckOfCards;
	}

	// Getter for single card at a given index.
	public Card getCard(int index) {

		return deckOfCards[index];
	}
	
	// Utilizing Random class and swap method to shuffle deck.
	public void shuffle() {
		Random random = new Random();

		for (int i = 0; i < SIZE; i++) {
			int j = random.nextInt(SIZE);
			swapCards(i, j);
		}
	}
	
	// Standard swap method utilizes temp variable to execute swapping functionality. 
	public void swapCards(int i, int j) {
		Card temporaryCard = deckOfCards[i];
		deckOfCards[i] = deckOfCards[j];
		deckOfCards[j] = temporaryCard;

	}

}
