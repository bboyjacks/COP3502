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
     * HumanPlayer member variable
     */
    private Player mYou;
    private Player mDealer;
    private Deck mDeck;
    private InputParser mInputParser;
    private Integer mNumGames;
    private Integer mNumTies;

    /**
     * This constructs a Game object
     */
    Game() {
        mDeck = new Deck();
        mYou = new HumanPlayer(mDeck);
        mDealer = new BotPlayer();
        Scanner scanner = new Scanner(System.in);
        mInputParser = new InputParser(scanner);
        mNumGames = 1;
    }

    /**
     * Starts the game
     */
    public void start() {

        Options selectedInput = Options.GAME_START;

        System.out.println("START GAME #" + mNumGames);
        while (selectedInput != Options.EXIT) {

            draw(mYou);

            showOptions();

            Integer input = mInputParser.getInput();
            selectedInput = Options.convertToOptions(input);

            switch (selectedInput) {
                case GET_ANOTHER_CARD:
                    draw(mYou);
                    break;
                case HOLD_HAND: {
                    draw(mDealer);
                    evaluateWinner(mYou, mDealer);
                    break;
                }
                case PRINT_GAME_STATS: {
                    printStats();
                    break;
                }
            }
        }
    }

    /**
     * This prints the current stats of the game
     */
    private void printStats() {
        System.out.println("Number of Player wins: " + mYou.getNumWins());
        System.out.println("Number of Dealer wins: " + mDealer.getNumWins());
        System.out.println("Number of tie games: " + mNumTies);
        System.out.println("Total # of games played is: " + mNumGames);
        System.out.println("Percentage of Player wins: " + (mYou.getNumWins() / mNumGames) + "%");
    }

    /**
     * This method prints who wins
     * @param mYou
     * @param mDealer
     */
    private void evaluateWinner(Player mYou, Player mDealer) {
        if (mDealer.getTotalHandValue() == mYou.getTotalHandValue()) {
            System.out.println("It's a tie! No one wins!");
            mNumTies = mNumTies + 1;
        } else if (mDealer.getTotalHandValue() > mYou.getTotalHandValue()) {
            System.out.println("Dealer wins!");
            mDealer.addWin();
        } else {
            System.out.println("You win!");
            mYou.addWin();
        }
        System.out.println("START GAME #" + mNumGames);
    }

    /**
     * Draws and shows hand from specified player
     * @param _player
     */
    private void draw(Player _player) {
        _player.draw();
        _player.showHand();
    }

    /**
     * Shows the options available to users
     */
    private void showOptions() {
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
    }
}
