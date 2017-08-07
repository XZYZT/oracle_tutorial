package oracle.javase.tutorial.ilandi.defaultmethods.integrating;


public class PlayingCard implements Card{
	private Card.Rank rank;
	private Card.Suit suit;
	
	public PlayingCard(Card.Rank rank, Card.Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public int compareTo(Card o) {
		return this.hashCode() - o.hashCode();
	}
	
	public int hashCode() {
		return (suit.value() - 1)*13 + rank.value();
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Card){
			Card o = (Card)obj;
			if (o.getRank() == this.rank &&
				o.getSuit() == this.suit){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	@Override
	public String toString() {
		return this.rank.text() + " of " + this.suit.text();
	}
	
	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}
	public static void main(String[] args) {
		System.out.println(new PlayingCard(Rank.ACE, Suit.CLUBS));
	}
}
