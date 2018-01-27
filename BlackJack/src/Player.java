import java.util.ArrayList;

/**
 * Defines a player
 */
public class Player {

    /**
     * Member variables
     */
    private Deck mDeck;
    private ArrayList<Card> mCards;
    private Integer mNumWins;
    private String mName;

    /**
     * Creates a Player object
     */
    Player(String _name, Deck _deck) {
        mName = _name;
        mDeck = _deck;
        mCards = new ArrayList<Card>();
        mNumWins = 0;
    }

    /**
     * Draws one random card from the dect
     * and adds it to mCards
     */
    public void draw() {
        System.out.println("Your card is a " + mDeck.getTop().toString() + "!");
        mCards.add(mDeck.getTop());
    }

    /**
     * Shows players Hand
     */
    public void showHand() {
        System.out.println("Your hand is: " + getTotalHandValue());
        System.out.println();
    }

    /**
     * Set name
     */
    public void addWin() {
        mNumWins += 1;
    }

    /**
     * This calculates total hand value
     *
     * @return the total hand value
     */
    private Integer getTotalHandValue() {
        Integer total = 0;
        for (Card card : mCards) {
            total += card.mValue;
        }
        return total;
    }
}
