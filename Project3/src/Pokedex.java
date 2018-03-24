import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Pokedex implements PokedexInterface {

    private Pokemon[] pokemons;
    private int totalSpaces = 0;
    private int filledSpaces = 0;

    Pokedex(int _numTotalSpaces)
    {
        totalSpaces = _numTotalSpaces;
        pokemons = new Pokemon[totalSpaces];
    }

    @Override
    public String[] listPokemon() {
        if (filledSpaces > 0)
        {
            String[] pokemonList = new String[filledSpaces];
            for (int i = 0; i < filledSpaces; i++)
                pokemonList[i] = pokemons[i].getSpecies();
            return pokemonList;
        }
        else
            return null;
    }

    @Override
    public boolean addPokemon(String species) {
        if (0 <= filledSpaces && filledSpaces < totalSpaces)
        {
            pokemons[filledSpaces++] = new Pokemon(species);
            return true;
        }
        return false;
    }

    @Override
    public int[] checkStats(String species) {
        int[] stats = new int[0];
        for (int i = 0; i < filledSpaces; i++)
        {
            if (species.equals(pokemons[i]))
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
        Arrays.sort(pokemons, 0, filledSpaces);
    }

    @Override
    public boolean evolvePokemon(String species) {
        boolean success = false;
        for (int i = 0; i < filledSpaces; i++)
        {
            if (species.equals(pokemons[i].getSpecies()))
            {
                pokemons[i].setSpeed(pokemons[i].getSpeed() * 3);
                pokemons[i].setAttack(pokemons[i].getAttack() * 2);
                pokemons[i].setDefense(pokemons[i].getDefense() * 4);
                success = true;
                break;
            }
        }
        return success;
    }
}
