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
                    player = (Warrior) new Warrior();
                    break;
                case 2:
                    player = (Mage) new Mage();
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

    public static void print_combat(Adventurer player, Enemy enemy, int turn) {
        if (!player.isAlive() || !enemy.isAlive()) {
            System.out.println("------------  Turn End  ------------");
        } else {
            System.out.printf("------------  Turn %d  ------------\n", turn);
        }
        System.out.printf("%-22s%s\n", player.get_player_class(), enemy.get_enemy_class());
        System.out.printf("%-22s%s\n", "HP: " + player.get_curr_hp() + "/" + player.get_max_hp(), "HP: " + enemy.get_curr_hp() + "/" + enemy.get_max_hp());
        System.out.printf("%-22s%s\n", "MP: " + player.get_curr_mp() + "/" + player.get_max_mp(), "MP: " + enemy.get_curr_mp() + "/" + enemy.get_max_mp());
    }

    public static void attack(Adventurer player, Enemy enemy, int attack_type) {
        int p_atk, p_def, e_atk, e_def;
        float phy_atk_chance = ((float) enemy.get_attack() / (enemy.get_attack() + enemy.get_magic_attack()));
        System.out.printf("%d %d %f\n", enemy.get_attack(), enemy.get_magic_attack(), phy_atk_chance);
        int dmg;
        int go_first = 1;

        if (attack_type == 1) {
            p_atk = player.get_attack();
            e_def = enemy.get_defense();
            
        } else {
            p_atk = player.get_magic_attack();
            e_def = enemy.get_magic_defense();
        }

        if (Math.random() < phy_atk_chance) {
            e_atk = enemy.get_attack();
            p_def = player.get_defense();
        } else {
            e_atk = enemy.get_magic_attack();
            p_def = player.get_magic_defense();
        }

        if (player.get_speed() == enemy.get_speed()) {
            if (Math.random() >= 0.5) {
                go_first = 1;
            } else {
                go_first = 2;
            }
        } else if (player.get_speed() > enemy.get_speed()) {
            go_first = 1;
        } else {
            go_first = 2;
        }

        if (go_first == 1) {
            dmg = p_atk * 3 - e_def;
            if (dmg < 1) { dmg = 1; }
            player.attack(enemy, dmg, attack_type);
            System.out.printf("%s dealt %d damage to %s.\n", player.get_player_class(), dmg, enemy.get_enemy_class());

            if (!enemy.isAlive()) { return; }

            dmg = e_atk * 3 - p_def;
            if (dmg < 1) { dmg = 1; }
            enemy.attack(player, dmg, attack_type);
            System.out.printf("%s dealt %d damage to %s.\n", enemy.get_enemy_class(), dmg, player.get_player_class());

        } else {
            dmg = e_atk * 3 - p_def;
            if (dmg < 1) { dmg = 1; }
            enemy.attack(player, dmg, attack_type);
            System.out.printf("%s dealt %d damage to %s.\n", enemy.get_enemy_class(), dmg, player.get_player_class());

            if (!player.isAlive()) { return; }

            dmg = p_atk * 3 - e_def;
            if (dmg < 1) { dmg = 1; }
            player.attack(enemy, dmg, attack_type);
            System.out.printf("%s dealt %d damage to %s.\n", player.get_player_class(), dmg, enemy.get_enemy_class());
        }
    }

    public static boolean run_away() {
        return Math.random() >= 0.5;
    }

    public static void explore(Adventurer player) {
        print_gap();

        Enemy enemy = new Goblin(player.get_level());
        System.out.println(enemy.toString());

        int option = -1;
        int turn = 0;
        boolean game_end = false;
        while (!game_end) {
            print_combat(player, enemy, ++turn);
            if (player.isAlive() && enemy.isAlive()) {
                System.out.println("1. Attack     2. Magic Attack     3. Run");

                while (true) {
                    System.out.print("Choose an action: ");
                    option = validate_input(3);
                    if (option == -1) { continue; }
                    break;
                }

                switch (option) {
                    case 1:
                        attack(player, enemy, 1);
                        break;
                    case 2:
                        attack(player, enemy, 2);
                        break;
                    case 3:
                        if (run_away()) {
                            game_end = true;
                            System.out.println("YOU SUCCESSFULLY RAN AWAY.");
                        } else {
                            System.out.println("FAILED TO RUN AWAY.");
                        }
                        break;
                }
            } else if (!enemy.isAlive()) {
                int exp = enemy.get_exp();
                int gold = enemy.get_gold();
                System.out.printf("YOU WON! YOU'VE EARNED %d EXP AND %d GOLD.\n", exp, gold);
                player.set_curr_exp(player.get_curr_exp() + exp);
                player.set_gold(player.get_gold() + gold);
                break;
            } else {
                System.out.println("YOU HAVE DIED!");
                player.revive();
                break;
            }
            sc.nextLine();
            System.out.println();
        }

        enter_to_continue();
    }

    public static void show_stats(Adventurer player) {
        System.out.println(player.toString());
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
                    print_gap();
                    show_stats(player);
                    enter_to_continue();
                    break;
                case 3:
                    quit_game = true;
                    break;
            }

            if (!player.isAlive()) {
                print_gap();
                System.out.println("RIP IN MEMORIAM");
                show_stats(player);
                System.out.println("Game Over.");
                quit_game = true;
                enter_to_continue();
            }
        }
        System.out.println("\nThank you for playing!");
    }
}
