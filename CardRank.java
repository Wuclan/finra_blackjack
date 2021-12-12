public enum CardRank {

    ACE(11,"Ace"),TWO(2,"2"),THREE(3,"3"),FOUR(4,"4"),FIVE(5,"5"),SIX(6,"6"),SEVEN(7,"7"),EIGHT(8,"8"),
    NINE(9,"9"),TEN(10,"10"),JACK(10,"Jack"),QUEEN(10,"Queen"),KING(10,"King");

    private int point;
    private String displayName;

    private CardRank(int point,String displayName) {
        this.point = point;
        this.displayName = displayName;
    }

    public int getPoint() {
        return point;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
