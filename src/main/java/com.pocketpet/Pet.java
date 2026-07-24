public class Pet {
    private String name;
    private int hunger;
    private int happiness;
    private int energy;

    public Pet(String name) {
        this.name = name;
        this.hunger = 50;
        this.happiness = 50;
        this.energy = 100;
    }

    public void feed() {
        hunger -= 20;
        happiness += 5;
    }

    public void play() {
        happiness += 15;
        energy -= 20;
    }

    public void sleep() {
        energy += 30;
    }
}