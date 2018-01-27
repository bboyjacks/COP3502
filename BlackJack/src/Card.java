/**
 * This defines a Card
 */
public class Card {

    /**
     * Card member variables
     */
    public Integer mValue;
    public String mString;

    /**
     * This creates a Card object
     */
    Card(Integer _value, String _string) {
        mValue = _value;
        mString = _string;
    }

    /**
     * toString override
     */
    public String toString() {
        return mString;
    }
}
