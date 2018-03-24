import java.net.SocketPermission;
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
        Pokedex pokedex;
        while (true)
        {
            System.out.println("\nOutput " + outputCount++);
            System.out.println("Welcome to your new PokeDex!");
            System.out.print("How many Pokemon are in your region? ");
            try
            {
                userInput = Integer.parseInt(scanner.nextLine());
                pokedex = new Pokedex(30);

                while (userInput != EXIT) {

                    // Show options
                    System.out.println("\n1. List Pokemon");
                    System.out.println("2. Add Pokemon");
                    System.out.println("3. Check a Pokemon's Stats");
                    System.out.println("4. Evolve Pokemon");
                    System.out.println("5. Sort Pokemon");
                    System.out.println("6. Exit\n");

                    // Ask for user input
                    System.out.print("What would you like to do? ");
                    try
                    {
                        userInput = Integer.parseInt(scanner.nextLine());
                    }catch (NumberFormatException e)
                    {
                        e.printStackTrace();
                        break;
                    }

                    String species = "";
                    // Execute user input
                    switch (userInput) {
                        case LIST_POKEMON:
                            String[] pokemonList = pokedex.listPokemon();
                            for (int i = 0; i < pokemonList.length; i++)
                                System.out.println(pokemonList[i]);
                            break;
                        case ADD_POKEMON:
                            System.out.print("\nPlease enter the Pokemon of interest: ");
                            species = scanner.nextLine();
                            boolean addedPokemon = pokedex.addPokemon(species);
                            break;
                        case CHECK_POKEMON_STATS:
                            System.out.print("\nPlease enter the Pokemon of interest: ");
                            species = scanner.nextLine();
                            System.out.println("\nThe stats for " + species + " are:");
                            int[] stats = pokedex.checkStats(species);
                            if (stats.length > 0)
                            {
                                System.out.println("Attack: " + stats[0]);
                                System.out.println("Defense: " + stats[1]);
                                System.out.println("Speed: " + stats[2]);
                            }
                            else
                                System.out.println("Missing");
                            break;
                        case EVOLVE_POKEMON:
                            System.out.print("\nPlease enter the Pokemon of interest: ");
                            species = scanner.nextLine();
                            boolean evolved = pokedex.evolvePokemon(species);
                            System.out.println(species + " has evolved!");
                            break;
                        case SORT_POKEMON:
                            pokedex.sortPokedex();
                            break;
                    }
                }
            }catch (NumberFormatException e)
            {
                e.printStackTrace();
                break;
            }
            System.out.println();
            System.out.println("Your new Pokedex can hold " + userInput + " Pokemon. Let's start using it!");
        }
    }
}
