public class Pet {

    private String name;
    private int hunger;
    private int happiness;
    private int energy;

    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 0;

    public Pet(String name) {
        this.name = name;
        this.hunger = 50;
        this.happiness = 50;
        this.energy = 100;
    }

    public void feed() {
        hunger = Math.max(MIN_VALUE, hunger - 20);
        happiness = Math.min(MAX_VALUE, happiness + 5);
    }

    public void play() {
        happiness = Math.min(MAX_VALUE, happiness + 15);
        energy = Math.max(MIN_VALUE, energy - 20);
        hunger = Math.min(MAX_VALUE, hunger + 10);
    }

    public void sleep() {
        energy = Math.min(MAX_VALUE, energy + 30);
        hunger = Math.min(MAX_VALUE, hunger + 30);
        happiness = Math.max(MIN_VALUE, happiness - 15);
    }

    // GETTER

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getEnergy() {
        return energy;
    }
}