import java.util.Scanner;

public class Main {

    private static final int LIST_POKEMON = 1;
    private static final int ADD_POKEMON = 2;
    private static final int CHECK_POKEMON_STATS = 3;
    private static final int EVOLVE_POKEMON = 4;
    private static final int SORT_POKEMON = 5;
    private static final int EXIT = 6;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int outputCount = 1;
        int userInput = -1;
        boolean newGame = true;
        while (userInput != EXIT)
        {
            System.out.println("Output " + 1);
            System.out.println("Welcome to your new PokeDex!");
            System.out.print("How many Pokemon are in your region? ");
            userInput = scanner.nextInt();
            System.out.println();
            System.out.println("Your new Pokedex can hold " + userInput + " Pokemon. Let's start using it!");
            System.out.println();
            if (newGame)
            {
                // Show options
                System.out.println("1. List Pokemon");
                System.out.println("2. Add Pokemon");
                System.out.println("3. Check a Pokemon's Stats");
                System.out.println("4. Evolve Pokemon");
                System.out.println("5. Sort Pokemon");
                System.out.println("6. Exit\n");

                // Ask for user input
                System.out.print("What would you like to do? ");
                userInput = scanner.nextInt();

                // Execute user input
                switch (userInput)
                {
                    case LIST_POKEMON:
                        break;
                    case ADD_POKEMON:
                        break;
                    case CHECK_POKEMON_STATS:
                        break;
                    case EVOLVE_POKEMON:
                        break;
                    case SORT_POKEMON:
                        break;
                }
                newGame = false;
            }
        }
    }
}
