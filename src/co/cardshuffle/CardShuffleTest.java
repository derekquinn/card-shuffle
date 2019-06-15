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
	// Compare player 0 hand to other players for uniqueness 
	@Test 
	public void compareHandToOtherPlayers() {
		
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
	
	// Compare player 0 cards in hand to itself for uniqueness 
	
	@Test
	public void checkPlayerZeroForDuplicateCards() {
		Player[] player = DeckUtility.dealCardsToPlayers();
		Card[] playerOneHand = player[0].getHand(); 
		
		assertFalse(playerOneHand[0] == playerOneHand[1]);
		assertFalse(playerOneHand[0] == playerOneHand[2]);
		assertFalse(playerOneHand[0] == playerOneHand[3]);
		assertFalse(playerOneHand[0] == playerOneHand[4]);
		
	}
	
	// Verify game results for flush if true
	@Test
	public void flushTrue() {
		
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
	public void flushFalse() {
		
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
	public void pairTrue() {
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
	public void pairFalse() {
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
	public void threeOfAKindTrue() {
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
	public void threeOfAKindFalse() {
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
	
	@Test
	public void fullHouseTrue() {
		
		Player mockPlayer = new Player();
		
		Card cardA = new Card(Suit.HEART, Rank.ACE);
		Card cardB = new Card(Suit.SPADE, Rank.ACE);
		Card cardC = new Card(Suit.CLUB, Rank.ACE);
		Card cardD = new Card(Suit.CLUB, Rank.FOUR);
		Card cardE = new Card(Suit.DIAMOND, Rank.FOUR);
		
		Card[] mockHand = {cardA, cardB, cardC, cardD, cardE};	
		mockPlayer.setHand(mockHand);
		assertTrue(DeckUtility.checkFullHouse(mockPlayer));
		
	}
	@Test
	public void fullHouseFalse() {
		
		Player mockPlayer = new Player();
		
		Card cardA = new Card(Suit.HEART, Rank.ACE);
		Card cardB = new Card(Suit.SPADE, Rank.ACE);
		Card cardC = new Card(Suit.CLUB, Rank.ACE);
		Card cardD = new Card(Suit.CLUB, Rank.JACK);
		Card cardE = new Card(Suit.DIAMOND, Rank.QUEEN);
		
		Card[] mockHand = {cardA, cardB, cardC, cardD, cardE};	
		mockPlayer.setHand(mockHand);
		assertFalse(DeckUtility.checkFullHouse(mockPlayer));
		
	}
}
