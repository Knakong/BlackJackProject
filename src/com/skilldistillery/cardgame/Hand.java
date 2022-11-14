package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	protected List<Card> cards = new ArrayList<>();

	
	public String toString() {
		return " hand " + cards;
	}



	
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public Hand() {
	
	}
	
	public void addCard(Card card) {
		cards.add(card);
		
	}
	public void clear() {
		cards.removeAll(cards);
	}
	public abstract int  getHandValue(); 
		
	
}
