package com.skilldistillery.players;

import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer extends Player {

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	@Override
	public String toString() {
		return getName() + " ";
	}

	public Dealer(String name) {
		super(name);

	}
	public void firstCard(){
		
		List<Card> cards = getHand().getCards();
		int value = cards.get(0).getValue(cards.get(0));
		System.out.println(getName()+" ["+cards.get(0).toString()+"  Face Down Card ]" + value);
	}
	private Deck deck = new Deck();

	public Card dealCard() {

		Card card = deck.getCard();
		deck.removeCard();
		return card;

	}
}
