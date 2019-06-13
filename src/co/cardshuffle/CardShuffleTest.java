package co.cardshuffle;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class CardShuffleTest {
	// Test to make sure deck size is 52.
	@Test
	public void deckSize() {
		DeckOfCards deck = new DeckOfCards();
		Card[] testDeck = deck.getDeckOfCards();
		assertEquals(52, testDeck.length);
		
	}
	// Test to make sure cards are truly random and unique. 
	@Test
	public void randomCard() {
		DeckOfCards deck = new DeckOfCards();
		Random random = new Random();
		Card[] testDeck = deck.getDeckOfCards();
		// Draw six random cards from the deck
		int cardA = random.nextInt(deck.SIZE);
		int cardB = random.nextInt(deck.SIZE);
		int cardC = random.nextInt(deck.SIZE);
		int cardD = random.nextInt(deck.SIZE);
		int cardE = random.nextInt(deck.SIZE);
		int cardF = random.nextInt(deck.SIZE);
		// Verify that the cards are all unique 
		assertFalse(testDeck[cardA] == testDeck[cardB]);
		assertFalse(testDeck[cardC] == testDeck[cardD]);
		assertFalse(testDeck[cardE] == testDeck[cardF]);
	}

}
