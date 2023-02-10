package text_adventure_game;

import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);

    public static void enter_to_continue() {
        System.out.print("Press ENTER to continue... ");
        sc.nextLine();
    }

    public static void print_gap() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static int validate_input(int max) {
        if (!sc.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            sc.next();
            return -1;
        }

        int option = sc.nextInt();
        if (option < 1 || option > max) {
            System.out.println("Please enter a valid option.");
            return -1;
        }

        return option;
    }

    public static Adventurer init_character() {
        int option;
        Adventurer player = new Warrior();

        System.out.println("--------------\nClass Selector\n--------------\n1. Warrior\n2. Mage\n--------------");
        while (true) {
            System.out.print("Pick a character: ");
            option = validate_input(2);
            if (option == -1) { continue; }

            switch (option) {
                case 1:
                    player = new Warrior();
                    break;
                case 2:
                    player = new Mage();
                    break;   
            }

            break;
        }
        sc.nextLine();
        System.out.println();
        return player;
    }

    public static int pick_option() {
        int option = -1;

        System.out.println("What to do?\n-----------\n1. Explore\n2. Show Stats\n3. Quit Game");
        while (true) {
            System.out.print("Choose an option: ");
            option = validate_input(3);
            if (option == -1) { continue; }
            break;
        }
        sc.nextLine();
        System.out.println();
        return option;
    }

    public static void explore(Adventurer player) {
        
    }

    public static void show_stats(Adventurer player) {
        System.out.println(player.toString());
        enter_to_continue();
    }

    public static void main(String[] args) {
        boolean quit_game = false;
        int option;

        System.out.println("\n-----------------------------------\n| | |  WELCOME TO TEXVENTURE!  | | |\n-----------------------------------\n");
        Adventurer player = init_character();
        show_stats(player);

        System.out.println("\nTIME FOR AN ADVENTURE!\n");

        while (!quit_game) {
            print_gap();
            option = pick_option();

            switch (option) {
                case 1:
                    explore(player);
                    break;
                case 2:
                    show_stats(player);
                    break;
                case 3:
                    quit_game = true;
                    break;
            }
        }
        System.out.println("Thank you for playing!");
    }
}
