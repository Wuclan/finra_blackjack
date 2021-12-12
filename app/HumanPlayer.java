package app;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {

    //cards players hold should be maintained by Table
    //private List<BlackJackCard> cardsHeld;
    

    public HumanPlayer(String id) {
        super(id);
    }

    @Override
    public String getDisplayName() {
        return "player " + getID();
    }

    @Override
    public boolean isHuman() {
        return true;
    }

    @Override
    public boolean hit(List<BlackJackCard> hand) {

        try(Scanner in = new Scanner(System.in)) {
            return "HIT".equals(in.nextLine().toUpperCase());
        }
    }
   
}