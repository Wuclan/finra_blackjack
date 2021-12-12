package app;
public class BlackJackCard {
    private Card card;
    private boolean faceDown;

    public BlackJackCard(Card card, boolean faceDown) {
        this.card = card;
        this.faceDown = faceDown;
    }

    public Card getCard() {
        return card;
    }

    public boolean isFaceDown() {
        return faceDown;
    }

    public void setFaceDown(boolean faceDown) {
        this.faceDown = faceDown;
    }

    public int getPoint() {
        return card.getRank().getPoint();
    }

    @Override
    public String toString() {
        if(faceDown) {
            return "face down";
        }
        return card.toString();
    }
}