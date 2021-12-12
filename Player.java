import java.util.List;

public interface Player {
    public boolean hit(List<BlackJackCard> hand);
    public boolean isHuman();
    public String getID();
    public String getDisplayName();
}
