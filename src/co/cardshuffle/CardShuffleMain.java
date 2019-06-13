package co.cardshuffle;

public class CardShuffleMain {

	public static void main(String[] Args) {

		DeckOfCards doc = new DeckOfCards();

		Card[] testDeck = doc.getDeckOfCards();

		for (int i = 0; i < 52; i++) {
			System.out.println(testDeck[i]);

		}

	}

}
