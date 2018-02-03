import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static final int GET_ANOTHER_CARD   = 1;
    private static final int HOLD_HAND          = 2;
    private static final int PRINT_STATS        = 3;
    private static final int EXIT               = 4;

    public static void main(String[] arg) throws FileNotFoundException {

        ByteArrayInputStream in = new ByteArrayInputStream("1 1 1 2 1 1 1 1 2 1 1 1 2 1 1 6 3 4".getBytes());
        Scanner SCANNER = new Scanner(in);


        System.setOut(new PrintStream(new FileOutputStream("MyOutput.txt")));

        P1Random p1random = new P1Random();
        int     numOfGames          = 1;

        int     playerCardValue     = 0;
        String  playerCardString    = "";
        int     playerTotalHand     = 0;
        int     playerNumWins       = 0;
        int     dealerNumWins       = 0;
        int     numTies             = 0;
        Boolean newGame             = true;
        Boolean showCard            = true;

        // Initial values
        int input = GET_ANOTHER_CARD;

        while (input != EXIT)
        {
            if (newGame)
            {
                System.out.println("START GAME #" + numOfGames);
                newGame = false;
            }

            while (input == GET_ANOTHER_CARD)
            {
                if (showCard)
                {
                    int randomInt       = p1random.nextInt(13) + 1;
                    playerCardValue     = getCardValue(randomInt);
                    playerCardString    = getCardString(randomInt);
                    playerTotalHand    += playerCardValue;
                    System.out.println("\nYour card is a "  + playerCardString + "!");
                    System.out.println("Your hand is: "     + playerTotalHand);
                    System.out.println();
                }
                else
                {
                    showCard = true;
                }

                if (playerTotalHand == 21)
                {
                    System.out.println("BLACKJACK! You win!\n");
                    numOfGames      += 1;
                    playerTotalHand  = 0;
                    newGame          = true;
                    playerNumWins   += 1;
                    break;
                }
                else if (playerTotalHand > 21)
                {
                    System.out.println("You exceeded 21! You lose.\n");
                    dealerNumWins   += 1;
                    numOfGames      += 1;
                    playerTotalHand  = 0;
                    newGame          = true;
                    break;
                }
                else
                    {
                        if (!newGame) {
                            showOptions();
                        }

                        input = SCANNER.nextInt();
                        System.out.println(input);
                    }
            }

            if (input == HOLD_HAND)
            {
                int dealerHand = p1random.nextInt(11) + 16;

                System.out.println("\nDealer's hand: "  + dealerHand);
                System.out.println("Your hand is: "     + playerTotalHand);

                if (dealerHand > 21)
                {
                    System.out.println("\nYou win!");
                    playerNumWins += 1;
                }
                else if (playerTotalHand == dealerHand)
                {
                    System.out.println("\nIt's a tie! No one wins!");
                    numTies += 1;
                }
                else if (playerTotalHand > dealerHand)
                {
                    System.out.println("\nYou win!");
                    playerNumWins += 1;
                }
                else
                {
                    System.out.println("\nYou lose!");
                    dealerNumWins += 1;
                }

                newGame = true;
                playerTotalHand = 0;
                numOfGames += 1;
                input = GET_ANOTHER_CARD;
                System.out.println();
            }

            if (input == PRINT_STATS)
            {
                System.out.println("\nNumber of Player wins: " + playerNumWins);
                System.out.println("Number of Dealer wins: " + dealerNumWins);
                System.out.println("Number of tie games: " + numTies);
                System.out.println("Total # of games played is: " + (numOfGames - 1));
                System.out.println("Percentage of Player wins: " + (double)(playerNumWins) * 100 / (numOfGames - 1) + "%\n");
                input = GET_ANOTHER_CARD;
                showCard = false;
            }

            if (input != EXIT && input != GET_ANOTHER_CARD && input != HOLD_HAND && input != PRINT_STATS)
            {
                System.out.println("\nInvalid input!");
                System.out.println("Please enter an integer value between 1 and 4.\n");
                input = GET_ANOTHER_CARD;
                showCard = false;
            }
        }
    }

    private static void showOptions() {
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
        System.out.print("\nChoose an option: ");
    }

    private static int getCardValue(int _randomInt)
    {
        int returnInt = 0;
        if (0 < _randomInt && _randomInt <= 10)
        {
            returnInt = _randomInt;
        }
        else
        {
            returnInt = 10;
        }
        return returnInt;
    }

    private static String getCardString(int _randomInt)
    {
        String returnString = "";
        if (1 < _randomInt && _randomInt <= 10)
        {
            returnString = Integer.toString(_randomInt);
        }
        else if (_randomInt == 1)
        {
            returnString = "ACE";
        }
        else if (_randomInt == 11)
        {
            returnString = "JACK";
        }
        else if (_randomInt == 12)
        {
            returnString = "QUEEN";
        }
        else
        {
            returnString = "KING";
        }
        return returnString;
    }

}
