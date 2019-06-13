package co.cardshuffle;

import java.util.Arrays;

public class Player {

	String name;
	Card[] hand = new Card[5];

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card[] getHand() {
		return hand;
	}

	public void setHand(Card[] hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", hand=" + Arrays.toString(hand) + "]";
	}

}
