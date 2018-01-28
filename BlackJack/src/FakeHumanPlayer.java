import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Stack;

public class FakeHumanPlayer implements Player {

    private Stack<Card> mDeck;
    private ArrayList<Card> mCards;
    private Integer mNumWins;

    FakeHumanPlayer(PrintStream _out) {
        mDeck = new Stack<Card>();
        mCards = new ArrayList<Card>();
        mDeck.add(new Card(1, "ACE"));
        mDeck.add(new Card(2, "2"));
        mDeck.add(new Card(8, "8"));
        mDeck.add(new Card(5, "5"));
        mNumWins = 0;
        System.setOut(_out);
    }

    @Override
    public void draw() {
        Card card = mDeck.pop();
        System.out.println("Your card is a " + card.mString + "!");
        mCards.add(card);
    }

    @Override
    public void showHand() {
        System.out.println("Your hand is: " + getTotalHandValue());
    }

    @Override
    public void addWin() {
        mNumWins = mNumWins + 1;
    }

    @Override
    public Integer getNumWins() {
        return mNumWins;
    }

    @Override
    public Integer getTotalHandValue() {
        Integer total = 0;
        for (Card card : mCards) {
            total += card.mValue;
        }
        return total;
    }
}
