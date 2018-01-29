import java.util.Scanner;

public class Main {

    public static final int     GET_ANOTHER_CARD    = 1;
    public static final int     HOLD_HAND           = 2;
    public static final int     PRINT_GAME_STATS    = 3;
    public static final int     EXIT                = 4;

    public static P1Random  mP1Random   = new P1Random();
    public static Card      mNewCard     = new Card();
    public static Scanner   mScanner    = new Scanner(System.in);

    public static class Card {
        public Integer  mValue          = 0;
        public String   mDescription    = "";
    }

    public static class GameState {
        Integer mDealerTotalHand        = 0;
        Integer mDealerNumWins          = 0;
        Integer mHumanPlayerTotalHand   = 0;
        Card    mHumanPlayerCard;
        Integer mHumanPlayerNumWins     = 0;
        Integer mInput                  = GET_ANOTHER_CARD;
        Integer mNumGames               = 1;
        boolean mNewGame                = true;
        Integer mNumTies                = 0;
        String  mWinnerMessage          = "";
    }

    public static Card generateRandomCard() {
        int randomInt = mP1Random.nextInt(13) + 1;
        switch (randomInt) {
            case 1:
                mNewCard.mValue          = 1;
                mNewCard.mDescription    = "ACE";
                break;
            case 2:
                mNewCard.mValue          = 2;
                mNewCard.mDescription    = "2";
                break;
            case 3:
                mNewCard.mValue          = 3;
                mNewCard.mDescription    = "3";
                break;
            case 4:
                mNewCard.mValue          = 4;
                mNewCard.mDescription    = "5";
                break;
            case 5:
                mNewCard.mValue          = 5;
                mNewCard.mDescription    = "5";
                break;
            case 6:
                mNewCard.mValue          = 6;
                mNewCard.mDescription    = "6";
                break;
            case 7:
                mNewCard.mValue          = 7;
                mNewCard.mDescription    = "7";
                break;
            case 8:
                mNewCard.mValue          = 8;
                mNewCard.mDescription    = "8";
                break;
            case 9:
                mNewCard.mValue          = 9;
                mNewCard.mDescription    = "9";
                break;
            case 10:
                mNewCard.mValue          = 10;
                mNewCard.mDescription    = "10";
                break;
            case 11:
                mNewCard.mValue          = 10;
                mNewCard.mDescription    = "JACK";
                break;
            case 12:
                mNewCard.mValue          = 10;
                mNewCard.mDescription    = "QUEEN";
                break;
            case 13:
                mNewCard.mValue          = 10;
                mNewCard.mDescription    = "KING";
                break;

        }
        return mNewCard;
    }

    private static void evaluateWinner(GameState _gameState) {
        _gameState.mDealerTotalHand = mP1Random.nextInt(11) + 16;
        if (_gameState.mHumanPlayerTotalHand > _gameState.mDealerTotalHand) {
            _gameState.mHumanPlayerNumWins = _gameState.mHumanPlayerNumWins + 1;
            _gameState.mWinnerMessage = "You win!";
        } else if (_gameState.mHumanPlayerTotalHand < _gameState.mDealerTotalHand){
            _gameState.mDealerNumWins = _gameState.mDealerNumWins + 1;
            _gameState.mWinnerMessage = "Dealer wins!";
        } else {
            _gameState.mNumTies = _gameState.mNumTies + 1;
            _gameState.mWinnerMessage = "It's a tie! No one wins!";
        }
        _gameState.mNumGames    = _gameState.mNumGames + 1;
        _gameState.mNewGame     = true;
        _gameState.mInput       = GET_ANOTHER_CARD;
    }

    public static void main(String[] arg) {

        // Setup
        GameState gameState     = new GameState();

        while (gameState.mInput != EXIT) {
            switch (gameState.mInput) {
                case GET_ANOTHER_CARD:
                    gameState.mHumanPlayerCard = generateRandomCard();
                    gameState.mHumanPlayerTotalHand = gameState.mHumanPlayerTotalHand + gameState.mHumanPlayerCard.mValue;
                    printGetAnotherCard(gameState);
                    break;
                case HOLD_HAND:
                    evaluateWinner(gameState);
                    printHoldHand(gameState);
                    gameState.mDealerTotalHand = 0;
                    gameState.mHumanPlayerTotalHand = 0;
                    break;
                case PRINT_GAME_STATS:
                    printGameStats(gameState);
                    break;
            }

            gameState.mInput = mScanner.nextInt();
        }
    }

    private static void printGetAnotherCard(GameState _gameState) {
        if (_gameState.mNewGame) {
            System.out.println("START GAME # " + _gameState.mNumGames);
            _gameState.mNewGame = false;
        }

        System.out.println("\nYour card is a " + _gameState.mHumanPlayerCard.mDescription + "!");
        System.out.println("Your hand is: " + _gameState.mHumanPlayerTotalHand);

        printOptions();

        printChooseOption();
    }

    private static void printHoldHand(GameState _gameState) {
        System.out.println("\nDealer's hand: " + _gameState.mDealerTotalHand);
        System.out.println("Your hand is: " + _gameState.mHumanPlayerTotalHand);

        System.out.println("\n" + _gameState.mWinnerMessage);

        printChooseOption();
    }

    private static void printGameStats(GameState _gameState) {
        System.out.println("\nNumber of Player wins: " + _gameState.mHumanPlayerNumWins);
        System.out.println("Number of Dealer wins: " + _gameState.mDealerNumWins);
        System.out.println("Number of tie games: " + _gameState.mNumTies);
        System.out.println("Total # of games played is: " + _gameState.mNumGames);
        System.out.println("Percentage of Player wins: " + ((double)(_gameState.mHumanPlayerNumWins) / (double)(_gameState.mNumGames)) + "%");

        printChooseOption();
    }

    private static void printChooseOption() {
        System.out.print("\nChoose an option: ");
    }

    private static void printOptions() {
        System.out.println("\n1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
    }
}
