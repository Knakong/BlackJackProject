package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
private List<Card> deck = new ArrayList<>();

public Deck() {
	Rank[] ranks = Rank.values();
	Suit[] suits = Suit.values();
	
	for (Rank rank : ranks) {
		for (Suit suit : suits ) {
			deck.add( new Card(rank,suit));
		}
	}
shuffle();
}

public Card getCard() {
	return deck.get(0);
}
public Card dealCard() {
	
	return deck.remove(0);
	
}
public void shuffle() {
	Collections.shuffle(deck);
}
public void checkDeckSize() {
	System.out.println(deck.size());
}
}
