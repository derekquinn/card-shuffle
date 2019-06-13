package co.cardshuffle;

import java.util.Arrays;

public class Player {

	Card[] hand = new Card[5];

	public Card[] getHand() {
		return hand;
	}

	public void setHand(Card[] hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return "" + Arrays.toString(hand);
	}

}
