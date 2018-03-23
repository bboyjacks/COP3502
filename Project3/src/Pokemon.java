public class Pokemon {

    Pokemon(String _species)
    {
        species = _species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private String species;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    private int attack;
    private int defense;
    private int speed;

}
