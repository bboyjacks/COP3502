import java.util.ArrayList;

/**
 * Defines a player
 */
public class HumanPlayer implements Player {

    /**
     * Member variables
     */
    private Deck mDeck;
    private ArrayList<Card> mCards;
    private Integer mNumWins;

    /**
     * Creates a HumanPlayer object
     */
    HumanPlayer(Deck _deck) {
        mDeck = _deck;
        mCards = new ArrayList<Card>();
        mNumWins = 0;
    }

    /**
     * Draws one random card from the dect
     * and adds it to mCards
     */
    @Override
    public void draw() {
        System.out.println("Your card is a " + mDeck.getTop().toString() + "!");
        mCards.add(mDeck.getTop());
    }

    /**
     * Shows players Hand
     */
    @Override
    public void showHand() {
        System.out.println("Your hand is: " + getTotalHandValue());
    }

    /**
     * Set name
     */
    @Override
    public void addWin() {
        mNumWins = mNumWins +  1;
    }

    /**
     * Gets the toal number of wins
     */
    @Override
    public Integer getNumWins() {
        return mNumWins;
    }

    /**
     * This calculates total hand value
     *
     * @return the total hand value
     */
    @Override
    public Integer getTotalHandValue() {
        Integer total = 0;
        for (Card card : mCards) {
            total += card.mValue;
        }
        return total;
    }
}
