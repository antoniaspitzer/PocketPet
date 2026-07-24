import java.util.Scanner;

public class Game {

    private Pet pet;

    public Game(Pet pet) {
        this.pet = pet;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 Feed");
            System.out.println("2 Play");
            System.out.println("3 Sleep");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    pet.feed();
                    break;
                case 2:
                    pet.play();
                    break;
                case 3:
                    pet.sleep();
                    break;
            }
        }
    }
}