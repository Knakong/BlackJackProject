package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	protected List<Card> cards = new ArrayList<>();
	public Hand() {
	
	}
	
	public void addCard(Card card) {
		cards.add(card);
		
	}
	public void clear() {
		cards.removeAll(cards);
	}
	public abstract int  getHandValue(); {
		
	}
}
