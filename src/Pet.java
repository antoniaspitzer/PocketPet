public class Pet {

    private String name;
    private int hunger;
    private int happiness;
    private int energy;
    private String message;

    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 0;

    public Pet(String name) {
        this.name = name;
        this.hunger = 50;
        this.happiness = 50;
        this.energy = 100;
        this.message = "";
    }

    public void feed() {
        if (hunger <= MIN_VALUE) {
            System.out.println(name + " is already full! They don't eat!");
            return;
        }

        hunger = Math.max(MIN_VALUE, hunger - 20);
        happiness = Math.min(MAX_VALUE, happiness + 5);
        System.out.println(name + " enjoyed the meal!");
    }

    public void play() {
        if (happiness >= MAX_VALUE) {
            System.out.println(name + " is already happy. They don't want to play!");
            return;
        }

        happiness = Math.min(MAX_VALUE, happiness + 15);
        energy = Math.max(MIN_VALUE, energy - 20);
        hunger = Math.min(MAX_VALUE, hunger + 10);
        System.out.println(name + " loved playing with you!");
    }

    public void sleep() {
        if (energy >= MAX_VALUE) {
            System.out.println(name + "'s energy is already high up. They don't want to sleep!");
            return;
        }
        
        energy = Math.min(MAX_VALUE, energy + 30);
        hunger = Math.min(MAX_VALUE, hunger + 30);
        happiness = Math.max(MIN_VALUE, happiness - 15);
        System.out.println(name + " had a good-night-sleep!");
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

    public String getMessage() {

        String message = "";

        if (hunger >= 90) {
            message += name + " is really hungry...\n";
        }

        if (happiness <= 10) {
            message += name + " is really sad...\n";
        }

        if (energy <= 10) {
            message += name + " is really sleepy...\n";
        }

        return message;
    }
}



/*


        if (happiness <= 10) {
            System.out.println(name + " is really sad...");
        }

        if (energy <= 10) {
            System.out.println(name + " is really sleepy...");
        }

        TODO:
        viele pets
        unterschiedliche pets (gadse, hundi, hasi)
        
*/