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
public Card removeCard() {
	
	return deck.remove(0);
	
}
public void shuffle() {
	Collections.shuffle(deck);
}
public int cardsLeftinDeck(){
int count = 0;
	for (Card card : deck) {
	int i = 0;
	if (card != null) {
		i++;
		count = i;
	}
}
	
return count;
}
public void checkDeckSize() {
	System.out.print(deck.size());
}
}
