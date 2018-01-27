import java.util.Collections;
import java.util.Stack;

/**
 * This class defines Deck
 */
public class Deck {

    /**
     * Deck member variables
     */
    private Stack<Card> mDeck;

    /**
     * This creates a Deck
     */
    Deck() {
        mDeck = new Stack<Card>();
        for (int i = 0; i < 4; i++) {
            mDeck.push(new Card(1, "ACE"));
            mDeck.push(new Card(2, "2"));
            mDeck.push(new Card(3, "3"));
            mDeck.push(new Card(4, "4"));
            mDeck.push(new Card(5, "5"));
            mDeck.push(new Card(6, "6"));
            mDeck.push(new Card(7, "7"));
            mDeck.push(new Card(8, "8"));
            mDeck.push(new Card(9, "9"));
            mDeck.push(new Card(10, "10"));
            mDeck.push(new Card(10, "JACK"));
            mDeck.push(new Card(10, "QUEEN"));
            mDeck.push(new Card(10, "KING"));
        }
    }

    /**
     * Gets the top of the Deck
     * @return Card object
     */
    public Card getTop() {
        return mDeck.pop();
    }

    /**
     * This randomly shuffles Deck
     */
    public void shuffle() {
        Collections.shuffle(mDeck);
    }
}
