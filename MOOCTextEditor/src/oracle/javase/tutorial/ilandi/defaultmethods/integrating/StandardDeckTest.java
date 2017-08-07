package oracle.javase.tutorial.ilandi.defaultmethods.integrating;

import java.util.Comparator;

public class StandardDeckTest {
	public static void main(String[] args) {
		Deck deck = new StandardDeck();
		deck.shuffle();
		System.out.println(deck.deckToString());
		
		deck.sort((card1, card2) -> card1.getRank().value() - card2.getRank().value());
		deck.sort(Comparator.comparing((card) -> card.getRank()));
		deck.sort(Comparator.comparing(Card::getRank));
		deck.sort((card1, card2) -> {
			int compVal = card1.getRank().value() - card2.getRank().value();
			if(compVal == 0) return card1.getSuit().value() - card2.getSuit().value();
			else return compVal;
		});
		deck.sort(Comparator
				.comparing(Card::getRank)
				.thenComparing(Comparator.comparing(Card::getSuit)));
		
		deck.sort(Comparator.comparing(Card::getRank)
				.reversed()
				.thenComparing(Comparator.comparing(Card::getSuit)));
	}
}
