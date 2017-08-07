package oracle.javase.tutorial.classes.examples;

import static java.util.Arrays.*;

public class DisplayDeck {
	public static void main(String[] args) {
		Deck deck = new Deck();
//		System.out.println(deepToString(deck.getCards()));
		for(int i = 0; i < 4; i ++){
			System.out.println(deepToString(deck.getCards()[i]));
		}
		
		System.out.println(deck.deckToString());
	}
	
}
