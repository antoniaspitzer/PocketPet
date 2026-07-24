public class ConsoleUI {

    public void showPetStatus(Pet pet) {

        System.out.println("------------------");
        System.out.println(pet.getName());
        System.out.println("------------------");

        System.out.println("Hunger: " + createBar(pet.getHunger()));
        System.out.println("Happiness: " + createBar(pet.getHappiness()));
        System.out.println("Energy: " + createBar(pet.getEnergy()));
        System.out.println(pet.getMessage());
    }


    private String createBar(int value) {

        int filled = value / 10;

        return "█".repeat(filled)
                + "░".repeat(10 - filled)
                + " " + value + "%";
    }
}