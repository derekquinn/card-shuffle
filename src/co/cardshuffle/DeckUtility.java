package co.cardshuffle;

public class DeckUtility {

	private static Player playerOne = new Player();
	private static Player playerTwo = new Player();
	private static Player playerThree = new Player();
	private static Player playerFour = new Player();
	private static Player playerFive = new Player();

	public static Player[] dealCardsToPlayers() {

		Player[] players = new Player[5];

		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		Card[] shuffledDeck = deck.getDeckOfCards();

		Card[] playerOneHand = { shuffledDeck[0], shuffledDeck[5], shuffledDeck[10], shuffledDeck[15], shuffledDeck[20] };
		playerOne.setHand(playerOneHand);

		Card[] playerTwoHand = { shuffledDeck[1], shuffledDeck[6], shuffledDeck[11], shuffledDeck[16], shuffledDeck[21] };
		playerTwo.setHand(playerTwoHand);

		Card[] playerThreeHand = { shuffledDeck[2], shuffledDeck[7], shuffledDeck[12], shuffledDeck[17],shuffledDeck[22] };
		playerThree.setHand(playerThreeHand);

		Card[] playerFourHand = { shuffledDeck[3], shuffledDeck[8], shuffledDeck[13], shuffledDeck[18],shuffledDeck[23] };
		playerFour.setHand(playerFourHand);

		Card[] playerFiveHand = { shuffledDeck[4], shuffledDeck[9], shuffledDeck[14], shuffledDeck[19],shuffledDeck[24] };
		playerFive.setHand(playerFiveHand);

		players[0] = playerOne;
		players[1] = playerTwo;
		players[2] = playerThree;
		players[3] = playerFour;
		players[4] = playerFive;

		return players;

	}

}
