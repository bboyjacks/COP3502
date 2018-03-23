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
        Pokedex pokedex = new Pokedex();
        while (true)
        {
            System.out.println("\nOutput " + outputCount++);
            System.out.println("Welcome to your new PokeDex!");
            System.out.print("How many Pokemon are in your region? ");
            userInput = scanner.nextInt();
            System.out.println();
            System.out.println("Your new Pokedex can hold " + userInput + " Pokemon. Let's start using it!");

            while (userInput != 6) {

                // Show options
                System.out.println("\n1. List Pokemon");
                System.out.println("2. Add Pokemon");
                System.out.println("3. Check a Pokemon's Stats");
                System.out.println("4. Evolve Pokemon");
                System.out.println("5. Sort Pokemon");
                System.out.println("6. Exit\n");

                // Ask for user input
                System.out.print("What would you like to do? ");
                userInput = scanner.nextInt();

                // Execute user input
                switch (userInput) {
                    case LIST_POKEMON:
                        String line = "Here";
                        break;
                    case ADD_POKEMON:
                        String line1 = "Here";
                        break;
                    case CHECK_POKEMON_STATS:
                        String line2 = "Here";
                        break;
                    case EVOLVE_POKEMON:
                        String line3 = "Here";
                        break;
                    case SORT_POKEMON:
                        String line4 = "Here";
                        break;
                }
            }
        }
    }
}
