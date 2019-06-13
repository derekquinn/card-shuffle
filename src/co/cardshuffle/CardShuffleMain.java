package co.cardshuffle;


public class CardShuffleMain {

	public static void main(String[] Args) {

		Player[] gamePlayers = DeckUtility.dealCardsToPlayers();

		for (int i = 0; i < 5; i++) {
			System.out.println("Player " + (i+1) + ": " + gamePlayers[i].toString());
		}
		
		

	}

}
