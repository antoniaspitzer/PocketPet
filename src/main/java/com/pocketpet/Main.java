package main.java.com.pocketpet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What name should your pet have?");

        String name = scanner.nextLine();
        
        Pet pet = new Pet(name);
        ConsoleUI ui = new ConsoleUI();

        Game game = new Game(pet, ui);

        game.start();
    }
}