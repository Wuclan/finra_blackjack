package app;
import java.util.List;
import java.util.ArrayList;


public class Driver {
    


    public static void main(String[] args) {
        int numPlayers = Integer.parseInt(args[0]);
        List<Player> players = new ArrayList<>(numPlayers);
        for(int i=0;i<numPlayers;i++) players.add(new HumanPlayer(i+""));
        BlackJackGame game = new BlackJackGame(players, 1);
        game.start();
    }
}