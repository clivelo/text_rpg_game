package text_adventure_game;

import java.util.Scanner;

public class Game {

    public static Adventurer init_character() {
        int option;
        Adventurer player = new Warrior();

        Scanner sc = new Scanner(System.in);
        System.out.println("--------------\nClass Selector\n--------------\n1. Warrior\n2. Mage");
        while (true) {
            System.out.print("Pick a character: ");
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                sc.next();
                continue;
            }

            option = sc.nextInt();
            if (option < 1 || option > 2) {
                System.out.println("Please enter a valid option.");
                continue;
            }

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
        sc.close();
        System.out.println();
        return player;
    }

    public static void main(String[] args) {
        Adventurer player = init_character();

        Scanner sc = new Scanner(System.in);
        System.out.println(player.toString());
        sc.close();
    }
}
