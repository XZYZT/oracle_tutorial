package oracle.javase.tutorial.ilandi.defaultmethods.integrating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * 标准卡牌
 * @author ShaQuan
 *
 */
public class StandardDeck implements Deck{
	private List<Card> entireDeck;
	
	public StandardDeck() {
		this.entireDeck = new ArrayList<Card>();
		for(Card.Suit s : Card.Suit.values()){
			for(Card.Rank r : Card.Rank.values()){
				this.entireDeck.add(new PlayingCard(r, s));
			}
		}
	}
	public StandardDeck(List<Card> existingList){
		this.entireDeck = existingList;
	}
	
	public List<Card> getCards() {
		return entireDeck;
	}

	public Deck deckFactory() {
		return new StandardDeck(new ArrayList<Card>());
	}

	public int size() {
		return entireDeck.size();
	}

	public void addCard(Card card) {
		entireDeck.add(card);
	}

	public void addCards(List<Card> cards) {
		entireDeck.addAll(cards);
	}
	
	public void addDeck(Deck deck) {
		List<Card> listToAdd = deck.getCards();
		entireDeck.addAll(listToAdd);
	}

	public void shuffle() {
		Collections.shuffle(entireDeck);
	}

	public void sort() {
		Collections.sort(entireDeck);
	}

	public void sort(Comparator<Card> c) {
		Collections.sort(entireDeck, c);
	}

	public String deckToString() {
		return this.entireDeck.stream().map(Card::toString).collect(Collectors.joining("\n"));
	}

	public Map<Integer, Deck> deal(int players, int numberOfCards)
			throws IllegalArgumentException {
		int cardsDealt = players * numberOfCards;//卡牌发放
		int sizeOfDeck = entireDeck.size();		//整个卡牌数
		if(cardsDealt > sizeOfDeck){
			throw new IllegalArgumentException("Number of players (" + players +
					") times number of cards to be dealt (" + numberOfCards + 
					") is greater than the number of cards in the deck" + 
					sizeOfDeck + ").");
		}
		Map<Integer, List<Card>> dealtDeck = entireDeck
				.stream()
				.collect(Collectors.groupingBy(
						card ->{int cardIndex = entireDeck.indexOf(card);
								if (cardIndex >= cardsDealt) return players + 1;
								else return (cardIndex % players) + 1;}));
		Map<Integer, Deck> mapToReturn = new HashMap<Integer, Deck>();
		
		for(int i = 1; i <= players + 1; i ++){
			Deck currentDeck = deckFactory();
			currentDeck.addCards(dealtDeck.get(i));
			mapToReturn.put(i, currentDeck);
		}
		return mapToReturn;
	}
	public static void main(String[] args) {
		StandardDeck myDeck = new StandardDeck();
		System.out.println("Creating decl:");
		myDeck.sort();
		System.out.println("Sorted deck:");
		System.out.println(myDeck.deckToString());
		myDeck.shuffle();
		myDeck.sort(
            Comparator.comparing(Card::getRank)
                .thenComparing(Comparator.comparing(Card::getSuit)));
        System.out.println("Sorted by rank, then by suit " +
            "with static and default methods");
        System.out.println(myDeck.deckToString());        
        myDeck.sort(
            Comparator.comparing(Card::getRank)
                .reversed()
                .thenComparing(Comparator.comparing(Card::getSuit)));
        System.out.println("Sorted by rank reversed, then by suit " +
            "with static and default methods");
        System.out.println(myDeck.deckToString());
	}
}
