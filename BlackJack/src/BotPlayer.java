public class BotPlayer implements Player {

    private Integer mNumWins;
    private Integer mTotalValue;
    private P1Random mRandomGenerator;

    /**
     * Constructs a BotPlayer
     */
    BotPlayer() {
        mRandomGenerator = new P1Random();
        mNumWins = 0;
    }

    /**
     * Draws a card
     */
    @Override
    public void draw() {
        mTotalValue = mRandomGenerator.nextInt(11) + 16;
    }

    /**
     * Shows bots hand
     */
    @Override
    public void showHand() {
        System.out.println();
    }

    /**
     * Increments bots num wins
     */
    @Override
    public void addWin() {
        mNumWins = mNumWins + 1;
    }

    /**
     * This gets the total number of wins for BotPlayer
     * @return Integer
     */
    @Override
    public Integer getNumWins() {
        return mNumWins;
    }

    /**
     * Gets the total hand value of BotPlayer
     * @return
     */
    @Override
    public Integer getTotalHandValue() {
        return mTotalValue;
    }
}
