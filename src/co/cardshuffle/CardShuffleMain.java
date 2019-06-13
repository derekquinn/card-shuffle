package co.cardshuffle;

public class CardShuffleMain {

	public static void main(String[] Args) {

		Player[] gamePlayers = DeckUtility.dealCardsToPlayers();
		String playerResult = "";

		for (int i = 0; i < 5; i++) {
			System.out.println("Player " + (i + 1) + " Hand: " + gamePlayers[i].toString());

			if (DeckUtility.checkFlush(gamePlayers[i]) == true) {
				playerResult = "Flush!!!!";
			} else if (DeckUtility.checkFullHouse(gamePlayers[i]) == true) {
				playerResult = "Full House!!!";
			} else if (DeckUtility.checkThreeOfAKind(gamePlayers[i]) == true) {
				playerResult = "Three of a Kind!!";
			} else if (DeckUtility.checkPair(gamePlayers[i]) == true) {
				playerResult = "Pair! ";
			} else {
				playerResult = "Nothing.";
			}

			System.out.println("--  Results: " + playerResult);
		}

	}

}
