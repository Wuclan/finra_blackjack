package test;

import org.junit.*;
import app.*;

import java.util.*;

public class BlackJackGameTest {

    private BlackJackGame game;

    List<Player> players;

    @Before
    public void setup() {
        players = new ArrayList<>();
        players.add(new HumanPlayer("1"));
        players.add(new HumanPlayer("2"));

        game = new BlackJackGame(players,2);
    }
    
    //TODO How do i test code with standard IN?
    //get library with Reflection Util to examine fields of tested class
}
