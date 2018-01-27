import java.util.Scanner;

/**
 * This starts the game
 *
 * Game has a player and a dealer
 */
public class Game {

    /**
     * Game options
     */
    public enum Options {
        GET_ANOTHER_CARD,
        HOLD_HAND,
        PRINT_GAME_STATS,
        EXIT,
        GAME_START;

        /**
         * This returns the Options based on _i
         * @param _i
         * @return
         */
        public static Options convertToOptions(Integer _i) {
            Options option = GAME_START;
            switch (_i) {
                case 1:
                    option = GET_ANOTHER_CARD;
                    break;
                case 2:
                    option = HOLD_HAND;
                    break;
                case 3:
                    option = PRINT_GAME_STATS;
                    break;
                case 4:
                    option = EXIT;
                    break;
                case 5:
                    option = GAME_START;
                    break;
            }
            return option;
        }
    }

    /**
     * Player member variable
     */
    private Player mYou;
    private Player mDealer;
    private Deck mDeck;
    private InputParser mInputParser;
    private Integer mNumGames;

    /**
     * This constructs a Game object
     */
    Game() {
        mDeck = new Deck();
        mYou = new Player("You", mDeck);
        mDealer = new Player("Dealer", mDeck);
        Scanner scanner = new Scanner(System.in);
        mInputParser = new InputParser(scanner);
        mNumGames = 1;
    }

    /**
     * Starts the game
     */
    public void start() {

        Options selectedInput = Options.GAME_START;

        while (selectedInput != Options.EXIT) {
            System.out.println("START GAME #" + mNumGames);
            System.out.println();

            mYouDraw();

            showOptions();
            Integer input = mInputParser.getInput();
            selectedInput = Options.convertToOptions(input);

            switch (selectedInput) {
                case GET_ANOTHER_CARD:
                    mYouDraw();
            }
        }
    }

    /**
     * mYou gets another card
     */
    private void mYouDraw() {
        mYou.draw();
        mYou.showHand();
    }

    /**
     * Shows the options available to users
     */
    private void showOptions() {
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
        System.out.println();
    }
}
