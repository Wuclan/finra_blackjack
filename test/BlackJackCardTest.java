package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.*;

public class BlackJackCardTest {

    private BlackJackCard blackJackCard;

    @Before
    public void setup() {
        Card c = new Card(CardRank.ACE,CardSuit.SPADE,"TestDeck");
        blackJackCard = new BlackJackCard(c,true);
    }

    @Test
    public void shouldFaceDown() {
        Assert.assertTrue(blackJackCard.isFaceDown());
        blackJackCard.setFaceDown(false);;
        Assert.assertFalse(blackJackCard.isFaceDown());

    }

    @Test
    public void checkSuiteRank() {
        Assert.assertEquals(CardRank.ACE, blackJackCard.getCard().getRank());
        Assert.assertEquals(CardSuit.SPADE, blackJackCard.getCard().getSuit());


    }
    
}
