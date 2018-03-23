import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Pokedex implements PokedexInterface {

    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

    @Override
    public String[] listPokemon() {
        String[] pokemonList;
        if (pokemons.size() == 0)
        {
            pokemonList = new String[1];
            pokemonList[0] = "empty";
        }
        else {
            pokemonList = new String[pokemons.size()];
            for (int i = 0; i < pokemons.size(); i++)
                pokemonList[i] = pokemons.get(i).getSpecies();
        }

        return pokemonList;
    }

    @Override
    public boolean addPokemon(String species) {
        pokemons.add(new Pokemon(species));
        return true;
    }

    @Override
    public int[] checkStats(String species) {
        Pokemon pokemon = new Pokemon(species);
        int[] stats = {pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpeed()};
        return stats;
    }

    @Override
    public void sortPokedex() {
        Comparator<Pokemon> pokeComp = (Pokemon first, Pokemon second) -> { return second.getSpecies().compareTo(first.getSpecies()); };
        Collections.sort(pokemons, pokeComp);
    }

    @Override
    public boolean evolvePokemon(String species) {
        return true;
    }
}
