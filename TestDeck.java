// package com.hackathon.dekofcards;

public class TestDeck {

	public static void main(String[] args) {
		
		Deck myDeck = new Deck();
		// for (Card card: myDeck.getCards()) {
		// 	card.showCard();
		// }
		
		Player deb = new Player("Deb");
		Player dealer = new Player("Dealer");

		deb.hit(myDeck);
		deb.hit(myDeck);
		dealer.hit(myDeck);
		dealer.hit(myDeck);

		// System.out.println(deb.getHand());
		// deb.getHand().get(0).showCard();
		// deb.getHand().get(1).showCard();
		// deb.getHand().get(2).showCard();

		// deb.handSum();

		boolean flag = false;
		String choice = "";
		
		while (true){
			System.out.println("Do you want to hit? y/n :");
			choice = System.console().readLine();
			if (choice == "y"){
				deb.hit(myDeck);
				
			} 
			else {
				break;
			}

			if (deb.getSumHand() > 21){
				System.out.println("Bust, you're a loser");
				System.out.println("Dealer wins");
				flag = true;
				break;
			}

		}

		while (!flag){
			if (dealer.getSumHand() < 17){
				dealer.hit(myDeck);
			}
			else {
				break;
			}
		}

		if (dealer.getSumHand() > deb.getSumHand() && dealer.getSumHand() <= 21){
			System.out.println("Bust, you're a loser");
			System.out.println("Dealer wins");
		}
		else {
			System.out.println("You win!");
		}









		if (deb.getSumHand() > 21){
			System.out.println("Bust");
		}

		// for (Card card: myDeck.getCards()) {
		// 	card.showCard();
		// }

	}
}
