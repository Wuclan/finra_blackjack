import java.util.List;

/**
 * this is a singleton, because it's not stateful
 */
public class CasinoStrategy implements PlayStrategy {

    private static final int STAND_LIMIT = 16;

    private static CasinoStrategy instance;

    public static CasinoStrategy getInstance() {
        if(instance == null) {
            instance = new CasinoStrategy();
        }
        return instance;
    }

    private CasinoStrategy() {
    }

    @Override
    public boolean hit(List<BlackJackCard> hand) {
        int sum = BlackJackGame.getPoint(hand);
        return STAND_LIMIT >= sum;
    }
    
}
