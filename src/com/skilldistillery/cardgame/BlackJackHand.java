package com.skilldistillery.cardgame;

import java.util.List;

import com.skilldistillery.cards.Card;

public class BlackJackHand extends Hand {
	boolean blackJack = false;
	boolean twentyOne = false;
	
	public boolean isBlackJack() {
		return blackJack;
	}

	

	public boolean isTwentyOne() {
		return twentyOne;
	}

	

	public boolean isBust() {
		return bust;
	}

	public void setBust(boolean bust) {
		this.bust = bust;
	}

	boolean bust = false;

	public BlackJackHand() {
		super();
	}

	@Override
	public int getHandValue() {

		List<Card> cards = getCards();
		int value = 0;

		for (Card card : cards) {
			int aCard = card.getValue(card);
			value = value + aCard;
		}
		return value;

	}

	public void checkBust(BlackJackHand hand) {
		

		if (getHandValue() > 21) {
			bust = true;
			
		}

		

	}

	public void checkBlackJack(BlackJackHand hand) {
		
		if (hand.getCards().size() == 2)
			if (getHandValue() == 21) {
				blackJack = true;
				
			}
		
	}

	public void checkTwentyOne(BlackJackHand Hand) {
		if (!(blackJack)) {
			if (getHandValue() == 21) {
				twentyOne = false;
			}
		}
	}

}
