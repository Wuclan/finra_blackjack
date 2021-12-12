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

        hand.add(createBlackJackCard(CardRank.TEN));
        Assert.assertTrue(casinoStrategy.hit(hand));

        hand.add(createBlackJackCard(CardRank.FIVE));
        Assert.assertTrue(casinoStrategy.hit(hand));

        hand.add(createBlackJackCard(CardRank.ACE));
        Assert.assertTrue(casinoStrategy.hit(hand));

        hand.add(createBlackJackCard(CardRank.ACE));
        Assert.assertFalse(casinoStrategy.hit(hand));

        Assert.assertEquals(17, BlackJackGame.getPoint(hand));
    }


    private BlackJackCard createBlackJackCard(CardRank rank) {
        Card c = new Card(rank,CardSuit.SPADE,"TestDeck");
        return new BlackJackCard(c,false);
    }
    
}
