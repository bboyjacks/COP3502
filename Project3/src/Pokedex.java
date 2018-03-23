public class Pokedex implements PokedexInterface {


    @Override
    public String[] listPokemon() {
        return new String[0];
    }

    @Override
    public boolean addPokemon(String species) {
        return false;
    }

    @Override
    public int[] checkStats(String species) {
        return new int[0];
    }

    @Override
    public void sortPokedex() {

    }

    @Override
    public boolean evolvePokemon(String species) {
        return false;
    }
}
