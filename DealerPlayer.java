import java.util.List;

public class DealerPlayer extends AbstractPlayer {

    private PlayStrategy strategy;

    public DealerPlayer(String id, PlayStrategy strategy) {
        super(id);
        this.strategy = strategy;
    }

    public boolean hit(List<BlackJackCard> hand) {
        return strategy.hit(hand);
    }

    @Override
    public boolean isHuman() {
        return false;
    }

    @Override
    public String getDisplayName() {
        return getID();
    }
    
}