package test;

import org.junit.*;
import app.*;

import java.util.*;

public class DeckTest {

    Set<Card> cards = new HashSet<>();

    @Test
    public void testCreateDeck() {
        Deck deck = new Deck(5);
        deck.shuffle();
        Card card = null;
        while( (card = deck.pop()) != null) {
            cards.add(card);
        }
        Assert.assertEquals(52 * 5, cards.size());

    }
    
}
