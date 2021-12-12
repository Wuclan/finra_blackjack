package test;

import org.junit.Assert;
import org.junit.Test;

import app.*;
import java.util.ArrayList;
import java.util.List;

public class CasinoStrategyTest {

    private CasinoStrategy casinoStrategy = CasinoStrategy.getInstance();

    @Test
    public void testHitOrStand() {
        List<BlackJackCard> hand = new ArrayList<>();
        Assert.assertTrue(casinoStrategy.hit(hand));

        hand.add(createBlackJackCard(CardRank.TEN,"testDeck"));
        Assert.assertTrue(casinoStrategy.hit(hand));

        hand.add(createBlackJackCard(CardRank.FIVE,"testDeck"));
        Assert.assertTrue(casinoStrategy.hit(hand));

        hand.add(createBlackJackCard(CardRank.ACE,"testDeck"));
        Assert.assertTrue(casinoStrategy.hit(hand));

        hand.add(createBlackJackCard(CardRank.ACE,"testDeck"));
        Assert.assertFalse(casinoStrategy.hit(hand));

        Assert.assertEquals(17, BlackJackGame.getPoint(hand));
    }

    @Test
    public void testHitOrStandWithAllAces() {
        List<BlackJackCard> hand = new ArrayList<>();
        for(int i=0;i<6;i++) {

            hand.add(createBlackJackCard(CardRank.ACE,"testDeck"+i));
            Assert.assertTrue("i is "+i,casinoStrategy.hit(hand));

        }
        hand.add(createBlackJackCard(CardRank.ACE,"testDeck"+16));
        Assert.assertFalse(casinoStrategy.hit(hand));
        Assert.assertEquals(17, BlackJackGame.getPoint(hand));

    }


    private BlackJackCard createBlackJackCard(CardRank rank,String deckName) {
        Card c = new Card(rank,CardSuit.SPADE,deckName);
        return new BlackJackCard(c,false);
    }
    
}
