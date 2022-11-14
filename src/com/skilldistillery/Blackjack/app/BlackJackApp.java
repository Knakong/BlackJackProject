package com.skilldistillery.Blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackJackApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BlackJackApp app = new BlackJackApp();
		int theSwitch = 1;
		while (theSwitch != 0) {
			theSwitch = app.run(sc);
		}
		System.out.println("Thanks for Playing");
		sc.close();
	}

	public int run(Scanner sc) {
		List<Player> players = new ArrayList<Player>();
		int goOn = 1;
		Player dealer = new Dealer("The Dealer");
		Player player1 = new Player("Player");

		players.add(player1);
		players.add(dealer);
		((Dealer) dealer).getDeck().checkDeckSize();
		System.out.println(" Standard deck of Cards BlackJack \n");
		for (Player player : players) {

			Card dealtcard = (((Dealer) dealer).dealCard());

			System.out.println(dealtcard.toString() + " to " + player.toString());

			player.takeCard(dealtcard);
		}

		for (Player player : players) {

			Card dealtcard = ((((Dealer) dealer).dealCard()));

			if (!(player instanceof Dealer)) {
				System.out.println(dealtcard.toString() + " to " + player.toString());
			}
			if (player instanceof Dealer) {
				System.out.println("Face Down Card to " + player.toString());
			}

			player.takeCard(dealtcard);

		}
		for (Player player : players) {

			player.getHand().checkBlackJack(player.getHand());

			if ((!(player instanceof Dealer)) || (player.getHand().isBlackJack())) {

				boolean staying = false;

				while ((!(player.getHand().isBust() || player.getHand().isTwentyOne() || player.getHand().isBlackJack()
						|| staying))) {

					((Dealer) dealer).firstCard();

					System.out.println((player) + " " + player.getHand() + " " + player.showValue());

					System.out.println("Hit or Stay, type Hit to hit. Anything else to stay");
					String answer = sc.nextLine();

					if (answer.equalsIgnoreCase("hit")) {

						Card dealtcard = (((Dealer) dealer).dealCard());

						System.out.println(dealtcard.toString() + " to " + player.toString());

						player.takeCard(dealtcard);

						player.getHand().checkTwentyOne(player.getHand());

						player.getHand().checkBust(player.getHand());

					}

					else {
						staying = true;

					}

				}
			}
		}

		System.out.println((dealer) + "" + (dealer.getHand()) + dealer.showValue());
		while (dealer.showValue() < 17) {
			Card dealtcard = (((Dealer) dealer).dealCard());
			System.out.println(dealtcard.toString() + " to " + dealer.toString());

			dealer.takeCard(dealtcard);
			System.out.println((dealer) + "" + (dealer.getHand()) + dealer.showValue());
			dealer.getHand().checkTwentyOne(dealer.getHand());

			dealer.getHand().checkBust(dealer.getHand());

		}

		for (Player player : players) {
			if ((player.getHand().isBlackJack()) && (!(player instanceof Dealer) && !dealer.getHand().isBlackJack())) {

				System.out.println(player + " wins with Black Jack! ! ! ");
				break;
			}
			if ((player.getHand().isBlackJack()) && (!(player instanceof Dealer) && dealer.getHand().isBlackJack())) {

				System.out.println(player + "Tied with Dealer. Dealer also has Black Jack");
				break;
			}
			if (player.getHand().isBust()) {
				if (!(player instanceof Dealer)) {
					if (dealer.getHand().isBust()) {
						System.out.println(player + "" + (player.getHand()) + player.showValue());
						System.out.println(player + " Push, TIE: Dealer Also Bust");
						break;
					}

					System.out.println(player + "" + (player.getHand()) + player.showValue());
					System.out.println(player + " Loses");
					break;
				}
			}

			if (player.getHand().isTwentyOne()) {
				System.out.println((player) + " got 21 ! ! !");
			}

			if (!(dealer.getHand().isBust())) {

				if (!(player instanceof Dealer || player.getHand().isBust() || player.getHand().isBlackJack())) {

					if (player.showValue() == dealer.showValue()) {
						System.out.println("Push, TIE WITH DEALER");
						break;
					} else if (player.showValue() > dealer.showValue()) {
						System.out.println(player + " Beats the Dealer!!!");
						break;
					}

					else if (player.showValue() < dealer.showValue()) {
						System.out.println(player + " loses");
						break;
					}

				}

			}

			if (dealer.getHand().isBust()) {

				if ((!(player instanceof Dealer)) && (!(player.getHand().isBust()))) {
					System.out.println(
							player + " beats " + dealer + "with" + player.getHand() + " " + player.showValue());
				}

			}

		}

		System.out.println("Hit 0 to Quit");
		String quit = sc.nextLine();

		if (quit.equals("0")) {
			goOn = 0;
		}
		return goOn;
	}

}
