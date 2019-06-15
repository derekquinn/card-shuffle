package co.cardshuffle;

public class DeckUtility {

	private static Player playerOne = new Player();
	private static Player playerTwo = new Player();
	private static Player playerThree = new Player();
	private static Player playerFour = new Player();
	private static Player playerFive = new Player();

	public static Player[] dealCardsToPlayers() {

		Player[] players = new Player[5];
		Card[] playerOneHand = new Card[5];
		Card[] playerTwoHand = new Card[5];
		Card[] playerThreeHand = new Card[5];
		Card[] playerFourHand = new Card[5];
		Card[] playerFiveHand = new Card[5];

		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		Card[] shuffledDeck = deck.getDeckOfCards();
		// Deal cards in a fashion similar to real life rotation of cards at a card
		// table.

		int card = 0;
			for (int i = 0; i <= 20; i += 5) {		
				playerOneHand[card] = shuffledDeck[i];
				playerTwoHand[card] = shuffledDeck[i + 1];
				playerThreeHand[card] = shuffledDeck[i + 2];
				playerFourHand[card] = shuffledDeck[i + 3];
				playerFiveHand[card] = shuffledDeck[i + 4];
				card++;
			}

		playerOne.setHand(playerOneHand);
		playerTwo.setHand(playerTwoHand);
		playerThree.setHand(playerThreeHand);
		playerFour.setHand(playerFourHand);
		playerFive.setHand(playerFiveHand);

		players[0] = playerOne;
		players[1] = playerTwo;
		players[2] = playerThree;
		players[3] = playerFour;
		players[4] = playerFive;

		return players;

	}

	// Check to see if all suits match on a given player's hand.
	public static boolean checkFlush(Player player) {
		Card[] playerHand = player.getHand();

		if (playerHand[0].getSuit() == playerHand[1].getSuit() && playerHand[0].getSuit() == playerHand[2].getSuit()
				&& playerHand[0].getSuit() == playerHand[3].getSuit()
				&& playerHand[0].getSuit() == playerHand[4].getSuit()) {
			return true;
		} else {
			return false;
		}
	}

	// Check player hand for pair
	public static boolean checkPair(Player player) {
		Card[] playerHand = player.getHand();

		for (int i = 0; i <= 4; i++) {
			for (int j = 4; j >= 0; j--) {
				if (j != i && playerHand[i].getRank() == playerHand[j].getRank()) {
					return true;
				}
			}
		}
		return false;
	}

	// Check player hand for three of a kind
	public static boolean checkThreeOfAKind(Player player) {

		Card[] playerHand = player.getHand();

		for (int i = 0; i <= 4; i++) {
			for (int j = 4; j >= 0; j--) {
				for (int k = 0; k <= 4; k++) {
					if (j != i && k != i && k != j && playerHand[i].getRank() == playerHand[j].getRank()
							&& playerHand[i].getRank() == playerHand[k].getRank()
							&& playerHand[k].getRank() == playerHand[j].getRank()) {
						return true;
					}
				}
			}
		}
		return false;

	}

	// Determine if player has full house (Pair + Three of a kind)
	public static boolean checkFullHouse(Player player) {

		Card[] playerHand = player.getHand();

		for (int i = 0; i <= 4; i++) {
			for (int j = 4; j >= 0; j--) {
				for (int k = 0; k <= 4; k++) {
					for (int l = 4; l >= 0; l--) {
						for (int m = 0; m <= 4; m++) {
							if (j != i && k != i && k != j && m != l && m != k && m != j && m != i
									&& playerHand[i].getRank() == playerHand[j].getRank()
									&& playerHand[i].getRank() == playerHand[k].getRank()
									&& playerHand[k].getRank() == playerHand[j].getRank()
									&& playerHand[m].getRank() == playerHand[l].getRank()) {
								return true;
							}
						}
					}

				}
			}
		}
		return false;
	}
}
