package app;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Scanner;

public class BlackJackGame {
    
    public final static int BLACK_JACK_POINT = 21;
    private Deck deck;
    private List<Player> players;
    private Map<Player,List<BlackJackCard>> hands;

    private static final int EXPECTED_HAND_SIZE = 5;
    int numberOfDecks;

    private DealerPlayer dealerPlayer;

    Scanner in = new Scanner(System.in);

    public BlackJackGame(List<Player> players, int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
        this.players = new ArrayList<>();
        this.players.addAll(players);
        deck = new Deck(numberOfDecks);
        deck.shuffle();
        dealerPlayer = new DealerPlayer("Computer",CasinoStrategy.getInstance());

        this.players.add(dealerPlayer);
    }

    public void newDeck() {
        deck = new Deck(numberOfDecks);
    }

    public void addPlayer(int place,Player player) {
        players.add(place,player);
    }


    public void start() {
        initialDeal();
        hands.get(this.dealerPlayer).get(0).setFaceDown(false);
        players.stream().forEach(player->play(player));
        players.stream()
            .filter(player->player != dealerPlayer)
            .forEach(player->score(player));
        in.close();
    }

    private void score(Player player) {
        int playerPoint = getPoint(player);
        int dealerPoint = getPoint(dealerPlayer);
        System.out.print("Scoring " + player.getDisplayName() + " has "+pointToString(playerPoint));
        System.out.print(", Dealer has " + pointToString(dealerPoint)+". ");
        if(playerPoint > BLACK_JACK_POINT) {
            System.out.println("Dealer wins.");
        }
        else if (dealerPoint > BLACK_JACK_POINT) {
            System.out.println(player.getDisplayName() + " wins.");
        }
        else {
            if(playerPoint > dealerPoint) {
                System.out.println(player.getDisplayName() + " wins.");
            }
            else if(playerPoint < dealerPoint) {
                System.out.println("Dealer wins.");
            }
            else {
                System.out.println("Draw."); 
            }
        }
    }

    private String pointToString(int point) {
        if(BLACK_JACK_POINT < point) {
            return "busted";
        }
        return point+"";
    }

    private void play(Player player) {
        boolean hit = true;
        int points = getPoint(player);
        while(hit && points <= BLACK_JACK_POINT) {
            deal(player);
            points = getPoint(player);
            if(points > BLACK_JACK_POINT) {
                System.out.println("Busted over 21.");
            }
            else if(player.isHuman()) {
                System.out.print("Hit or Stand? >");
                hit = "HIT".equals(in.nextLine().toUpperCase());
            }
            else {
                hit = player.hit(hands.get(player));
                System.err.println();
            }
        }
       
    }

    private void initialDeal() {
        hands = new HashMap<>();
        deck.shuffle();
        players.stream().forEach(player->{
            hands.put(player, new ArrayList<>(EXPECTED_HAND_SIZE));
            deal(player);
            System.out.println();
        });
    }
    private BlackJackCard deal(Player player) {
        Card card = deck.pop();
        List<BlackJackCard> hand = hands.get(player);
        BlackJackCard blackJackCard = 
            new BlackJackCard(card, 
                player instanceof DealerPlayer && hand.size() == 0);

        hand.add(blackJackCard);
        System.out.print("Dealing to " + player.getDisplayName() + " ");
        printPlayerHand(player);
        return blackJackCard;
    }

    private void printPlayerHand(Player player) {
        List<BlackJackCard> hand = hands.get(player);
        System.out.print("card"+(hand.size() > 0 ? "s: " : ": "));
        System.out.print(
            hand.stream().map(BlackJackCard::toString).collect(Collectors.joining(","))
        );
        System.out.print(". ");
    }

    private int getPoint(Player player) {
        return getPoint(hands.get(player));
    }

    public static int getPoint(List<BlackJackCard> hand) {
        final int[] cntAces = {0};
        int sum = hand.stream().map(card-> {
            if(card.getCard().getRank() == CardRank.ACE) {
                cntAces[0]++;
            }
            return card.getCard().getRank().getPoint();
        }).reduce(0,(a,b)->a+b);

        while(sum > BLACK_JACK_POINT && cntAces[0] > 0) {
            sum -= 10;
            cntAces[0]--;
        }

        return sum;
    }
}
