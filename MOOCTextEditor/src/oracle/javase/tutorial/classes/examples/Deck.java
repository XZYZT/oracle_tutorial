package oracle.javase.tutorial.classes.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
	public static int numSuits = 4;
    public static int numRanks = 13;
    public static int numCards = numSuits * numRanks;

    private Card[][] cards;
    
    public Deck() {
        cards = new Card[numSuits][numRanks];
        for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                cards[suit-1][rank-1] = new Card(rank, suit);
            }
        }
    }

    public Card getCard(int suit, int rank) {
        return cards[suit-1][rank-1];
    }
    
    public Card[][] getCards(){
    	return cards;
    }
    
    public List<Card> getCardList(){
    	List<Card> cardList = new ArrayList<Card>();
    	List<Card[]> cardArrList = Arrays.asList(cards);
    	for(Card[] cArr : cardArrList){
    		for(Card c : cArr){
    			cardList.add(c);
    		}
    	}
    	return cardList;
    }
    
    public String deckToString(){
    	return getCardList().stream().map(Card::toString).collect(Collectors.joining("\n"));
//    	return getCardList().stream().map(Card::toString).collect(Collectors.joining("\n"));
    }
    
    
}
