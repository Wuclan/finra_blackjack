import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    
    private List<Card> cards;

    public Deck(int numberOfDeck) {
        cards = new ArrayList<>(numberOfDeck*52);
        for(int i=0;i<numberOfDeck;i++) {
            createSingleDeck();
        }
    }

    public void shuffle() {
        Random random = new Random();
        for(int i=0;i<cards.size();i++) {
            int idx = random.nextInt(cards.size() - i);
            swap(i,idx);
        }
    }

    private void createSingleDeck() {
        for(CardRank rank:CardRank.values()) {
            for(CardSuit suit:CardSuit.values()) {
                cards.add(new Card(rank,suit));
            }
        }
    }
    private void swap(int i, int j) {
        Card iCard = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, iCard);
    }

    public Card pop() {
        return cards.remove(0);
    }
}
