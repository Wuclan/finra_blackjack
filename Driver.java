import java.util.List;
import java.util.ArrayList;


public class Driver {
    


    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("1"));
        players.add(new HumanPlayer("2"));
        players.add(new HumanPlayer("3"));
        BlackJackGame game = new BlackJackGame(players, 1);
        game.start();
    }
}