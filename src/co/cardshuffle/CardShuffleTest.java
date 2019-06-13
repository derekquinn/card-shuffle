package co.cardshuffle;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class CardShuffleTest {
	DeckOfCards d = new DeckOfCards();
	Card[] unshuffledDeck = d.getDeckOfCards();
	Random random = new Random();

	// Deck size is 52.
	@Test
	public void deckSize() {
		assertEquals(52, unshuffledDeck.length);
	}

	// Cards are truly random and unique.
	@Test
	public void randomCard() {
		// Draw six random cards from the deck
		int cardA = random.nextInt(d.SIZE);
		int cardB = random.nextInt(d.SIZE);
		int cardC = random.nextInt(d.SIZE);
		int cardD = random.nextInt(d.SIZE);
		int cardE = random.nextInt(d.SIZE);
		int cardF = random.nextInt(d.SIZE);
		
		// Verify that the cards are all unique
		assertFalse(unshuffledDeck[cardA] == unshuffledDeck[cardB]);
		assertFalse(unshuffledDeck[cardC] == unshuffledDeck[cardD]);
		assertFalse(unshuffledDeck[cardE] == unshuffledDeck[cardF]);
	}	
	// Integrity of shuffle deck method in DeckOfCards class 
	@Test
	public void shuffleDeck() {
		DeckOfCards deckB = new DeckOfCards();
		deckB.shuffle();
		Card[] shuffledDeck = deckB.getDeckOfCards();
		assertFalse(shuffledDeck == unshuffledDeck);

	}
	// Compare player hands for uniqueness 
	@Test 
	public void compareHands() {
		
		Player[] players = DeckUtility.dealCardsToPlayers();
		
		assertFalse(players[0].getHand() == players[1].getHand());
		assertFalse(players[0].getHand() == players[2].getHand());
		assertFalse(players[0].getHand() == players[3].getHand());
		assertFalse(players[0].getHand() == players[4].getHand());
		assertFalse(players[1].getHand() == players[2].getHand());
		assertFalse(players[1].getHand() == players[3].getHand());
		assertFalse(players[1].getHand() == players[4].getHand());
		assertFalse(players[2].getHand() == players[3].getHand());
		assertFalse(players[2].getHand() == players[4].getHand());
		assertFalse(players[3].getHand() == players[4].getHand());
	}
	
	// Verify game results for flush if true
	@Test
	public void verifyFlushTrue() {
		
		Player mockPlayer = new Player();
		
		Card cardA = new Card(Suit.HEART, Rank.ACE);
		Card cardB = new Card(Suit.HEART, Rank.EIGHT);
		Card cardC = new Card(Suit.HEART, Rank.NINE);
		Card cardD = new Card(Suit.HEART, Rank.FOUR);
		Card cardE = new Card(Suit.HEART, Rank.KING);
		Card[] mockHand = {cardA, cardB, cardC, cardD, cardE};	
		mockPlayer.setHand(mockHand);
		assertEquals(DeckUtility.checkFlush(mockPlayer), true);
			
	}
	
	// Verify game results for flush if false
	@Test
	public void verifyFlushFalse() {
		
		Player mockPlayer = new Player();
		
		Card cardA = new Card(Suit.CLUB, Rank.ACE);
		Card cardB = new Card(Suit.HEART, Rank.EIGHT);
		Card cardC = new Card(Suit.HEART, Rank.NINE);
		Card cardD = new Card(Suit.HEART, Rank.FOUR);
		Card cardE = new Card(Suit.HEART, Rank.KING);
		Card[] mockHand = {cardA, cardB, cardC, cardD, cardE};	
		mockPlayer.setHand(mockHand);
		assertEquals(DeckUtility.checkFlush(mockPlayer), false);
			
	}
	@Test
	public void verifyPairTrue() {
		Player mockPlayer = new Player();
		
		Card cardA = new Card(Suit.HEART, Rank.ACE);
		Card cardB = new Card(Suit.SPADE, Rank.ACE);
		Card cardC = new Card(Suit.CLUB, Rank.NINE);
		Card cardD = new Card(Suit.CLUB, Rank.FOUR);
		Card cardE = new Card(Suit.DIAMOND, Rank.KING);
		
		Card[] mockHand = {cardA, cardB, cardC, cardD, cardE};	
		mockPlayer.setHand(mockHand);
		assertTrue(DeckUtility.checkPair(mockPlayer));
		
	}
	@Test
	public void verifyPairFalse() {
		Player mockPlayer = new Player();
		
		Card cardA = new Card(Suit.HEART, Rank.TWO);
		Card cardB = new Card(Suit.SPADE, Rank.ACE);
		Card cardC = new Card(Suit.CLUB, Rank.NINE);
		Card cardD = new Card(Suit.CLUB, Rank.FOUR);
		Card cardE = new Card(Suit.DIAMOND, Rank.KING);
		
		Card[] mockHand = {cardA, cardB, cardC, cardD, cardE};	
		mockPlayer.setHand(mockHand);
		assertFalse(DeckUtility.checkPair(mockPlayer));
		
	}
	
	@Test
	public void verifyThreeOfAKindTrue() {
		Player mockPlayer = new Player();
		
		Card cardA = new Card(Suit.HEART, Rank.TWO);
		Card cardB = new Card(Suit.SPADE, Rank.TWO);
		Card cardC = new Card(Suit.CLUB, Rank.TWO);
		Card cardD = new Card(Suit.CLUB, Rank.FOUR);
		Card cardE = new Card(Suit.DIAMOND, Rank.KING);
		
		Card[] mockHand = {cardA, cardB, cardC, cardD, cardE};	
		mockPlayer.setHand(mockHand);
		assertTrue(DeckUtility.checkThreeOfAKind(mockPlayer));
		
	}
	
	@Test
	public void verifyThreeOfAKindFalse() {
		Player mockPlayer = new Player();
		
		Card cardA = new Card(Suit.HEART, Rank.ACE);
		Card cardB = new Card(Suit.SPADE, Rank.FIVE);
		Card cardC = new Card(Suit.CLUB, Rank.TWO);
		Card cardD = new Card(Suit.CLUB, Rank.FOUR);
		Card cardE = new Card(Suit.DIAMOND, Rank.KING);
		
		Card[] mockHand = {cardA, cardB, cardC, cardD, cardE};	
		mockPlayer.setHand(mockHand);
		assertFalse(DeckUtility.checkThreeOfAKind(mockPlayer));
		
	}
	
}
