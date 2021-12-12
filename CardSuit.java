public enum CardSuit {
    HEART("Heart"),SPADE("Spade"),DIAMOND("Diamond"),CLOVER("Clover");
    
    private String displayName;

    private CardSuit(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}