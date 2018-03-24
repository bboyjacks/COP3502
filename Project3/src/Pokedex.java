import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Pokedex implements PokedexInterface {

    private String[] pokemons;
    private int totalSpaces = 0;
    private int filledSpaces = 0;

    Pokedex(int _numTotalSpaces)
    {
        totalSpaces = _numTotalSpaces;
        pokemons = new String[totalSpaces];
    }

    @Override
    public String[] listPokemon() {
        String[] pokemonList;
        if (filledSpaces == 0)
        {
            pokemonList = new String[1];
            pokemonList[0] = "Empty";
        }
        else {
            pokemonList = new String[filledSpaces];
            for (int i = 0; i < filledSpaces; i++)
                pokemonList[i] = Integer.toString(i + 1) + " " + pokemons[i];
        }

        return pokemonList;
    }

    @Override
    public boolean addPokemon(String species) {
        if (0 <= filledSpaces && filledSpaces <= totalSpaces)
        {
            pokemons[filledSpaces++] = species;
            return true;
        }
        return false;
    }

    @Override
    public int[] checkStats(String species) {
        int[] stats = new int[0];
        for (int i = 0; i < filledSpaces; i++)
        {
            if (species == pokemons[i])
            {
                Pokemon pokemon = new Pokemon(species);
                stats = new int[]{pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpeed()};
                break;
            }
        }
        return stats;
    }

    @Override
    public void sortPokedex() {
        Arrays.sort(pokemons);
    }

    @Override
    public boolean evolvePokemon(String species) {
        return true;
    }
}
