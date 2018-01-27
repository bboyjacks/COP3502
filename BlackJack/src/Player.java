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

    /**
     * Creates a Player object
     */
    Player() {
        mDeck = new Deck();
        mCards = new ArrayList<Card>();
        mNumWins = 0;
    }

    /**
     * Draws one random card from the dect
     * and adds it to mCards
     */
    void draw() {
        mCards.add(mDeck.getTop());
    }

    /**
     * Shows players Hand
     */
    void showHand() {


        for (Card card : mCards) {

        }
    }
}
