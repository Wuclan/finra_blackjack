package app;
public class Card {

    private CardRank rank;
    private CardSuit suit;
    private String deckName;

    public Card(CardRank rank,CardSuit suit,String deckName) {
        this.rank = rank;
        this.suit = suit;
        this.deckName = deckName;
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank.getDisplayName() + " " + suit.getDisplayName();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((deckName == null) ? 0 : deckName.hashCode());
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (deckName == null) {
            if (other.deckName != null)
                return false;
        } else if (!deckName.equals(other.deckName))
            return false;
        if (rank != other.rank)
            return false;
        if (suit != other.suit)
            return false;
        return true;
    }

    
    
}
