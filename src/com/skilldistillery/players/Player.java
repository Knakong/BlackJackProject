package com.skilldistillery.players;

import com.skilldistillery.cardgame.BlackJackHand;
import com.skilldistillery.cards.Card;

public class Player {

	private String name;
	
	protected BlackJackHand hand = new BlackJackHand();
	
	
	public String toString() {
		return getName();
		
	}
	
	public Player(String name) {
		
		
		this.name = name;
	}
	public void takeCard(Card card) {
		hand.addCard(card);
		
	}
	public int showValue() {
		return hand.getHandValue();
	}
	public BlackJackHand getHand() {
		return hand;
	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
