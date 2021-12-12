package test;

import org.junit.*; 

import app.*;

public class PlayerTest {

    @Test
    public void testIsHuman() {
        Player p = new HumanPlayer("1");
        Assert.assertTrue(p.isHuman());

        p = new DealerPlayer("1",CasinoStrategy.getInstance());
        Assert.assertFalse(p.isHuman());
    }

}